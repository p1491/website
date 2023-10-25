terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "3.35.0"
    }
  }
   backend "azurerm" {
      resource_group_name  = "__TerraformBackend.ResourceGroup__"      
      storage_account_name = "__TerraformBackend.StorageAccount__"    
      container_name       = "__TerraformBackend.ContainerName__"
      key                  = "terraform.tfstate"
  }
}

provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "rg" {
  name     = "Agentrg"
  location = "eastus"
  tags = {
    "env" = "development"
    "app" = "cts"
  }
}

resource "azurerm_virtual_network" "my-net" {

  name                = "my-net"
  resource_group_name = azurerm_resource_group.rg.name
  location            = azurerm_resource_group.rg.location
  address_space       = ["10.0.0.0/16"]
}

resource "azurerm_subnet" "my-s1" {
  name                = "my-s1"
  resource_group_name = azurerm_resource_group.rg.name
  # location             = azurerm_resource_group.my.location
  address_prefixes     = ["10.0.1.0/24"]  
  virtual_network_name = azurerm_virtual_network.my-net.name
}

resource "azurerm_public_ip" "my-pip" {
  count = 1
  name                = "my-public-ip-${count.index}"
  location            = azurerm_resource_group.rg.location
  resource_group_name = azurerm_resource_group.rg.name
  allocation_method   = "Dynamic"

}

resource "azurerm_network_interface" "vm-nic" {
  count = 1
  name                = "vm-nic-${count.index}"
  resource_group_name = azurerm_resource_group.rg.name
  location            = azurerm_resource_group.rg.location
  ip_configuration {
    name                          = "internal"
    subnet_id                     = azurerm_subnet.my-s1.id
    private_ip_address_allocation = "Dynamic"
    public_ip_address_id          = azurerm_public_ip.my-pip[count.index].id

  }

}

resource "tls_private_key" "ssh" {
    algorithm = "RSA"
    rsa_bits = 4096
}

resource "azurerm_linux_virtual_machine" "vm1" {
  count = 1
  name                            = "agentvm"
  resource_group_name             = azurerm_resource_group.rg.name
  location                        = azurerm_resource_group.rg.location
  size                            = "Standard_B1s"
  admin_username                  = "ansible"
 
 admin_ssh_key {
        username = "ansible"
        public_key = tls_private_key.ssh.public_key_openssh
    }

  disable_password_authentication = true
  network_interface_ids = [
    azurerm_network_interface.vm-nic[count.index].id
  ]
  os_disk {
    caching              = "ReadWrite"
    storage_account_type = "Standard_LRS"
  }
  source_image_reference {
    publisher = "Canonical"
    offer     = "0001-com-ubuntu-server-jammy"
    sku       = "22_04-lts-gen2"
    version   = "latest"
  }
  boot_diagnostics {
    storage_account_uri = ""  
}
}

output "public_ip_address" {
  value = azurerm_public_ip.my-pip[0].ip_address
  depends_on = [azurerm_linux_virtual_machine.vm1[0]]
}

output "hostname" {
  value = azurerm_linux_virtual_machine.vm1[0].name
}

output "username" {
  value = azurerm_linux_virtual_machine.vm1[0].admin_username
}

output "private-ssh-key" {
  value     = tls_private_key.ssh.private_key_pem
  sensitive = true
}

output "public-ssh-key" {
  value     = tls_private_key.ssh.public_key_openssh
  sensitive = true
}

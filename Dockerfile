FROM centos:7
RUN yum install httpd -y
RUN systemctl enable httpd
COPY index.html /var/www/html
EXPOSE 80
CMD ["httpd", "-D","FOREGROUND"]

# sar

** Backend server deploy info **

Application is compiled using Java 1.8 and built using maven. Build and deploy consists of several steps:

1) Setting up database with enclosed script
2) Filling up passwords and address for database - copy file 'DBConfig_base.java' to 'DBConfig.java' in package main and fill the necessary info
3) Filling up passwords and address for email notifications - copy file 'MailSettings_base.java' to 'MailSettings.java' in package utils and fill the necessary info
4) Building the application using maven with 'package' goal
5) Resulting WAR file in folder 'target' can be deployed on any server supporting the format and Java 1.8 (tested on Tomcat 8.0.33)

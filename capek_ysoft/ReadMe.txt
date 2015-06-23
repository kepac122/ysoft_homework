Hello welcome to my homework project for Ysoft.

Used technologies :
JSP, JSTL, Spring MVC, Java, JPA, Hibernate, SpringQuickstartDS (H2 Database, part of JBoss), JBoss (preferably 1.7), Maven, Javascript (Datepickr library)

Requirement:
Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better and JBoss 7.1

How to deploy and run:

Preferably deploy WAR to Jboss in Eclipse environment and let Maven will solve all required dependecies and WAR building
Application runs on : http://localhost:8080/capek_ysoft/


If not possible this should be guideline to run it manually:

	1. Open a command line and navigate to the root of the JBoss server directory.
	2. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh
        For Windows: JBOSS_HOME\bin\standalone.bat
        
    3. Open a command line and navigate to the root directory
    4. Type this command to build and deploy the archive:

        mvn clean package jboss-as:deploy
        
The example uses the `java:jboss/datasources/SpringQuickstartDS` database        


Any further questions send to : kepac122@gmail.com



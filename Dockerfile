FROM tomcat:10.1.41-jdk17
RUN rm -rf /usr/local/tomcat/webapps/*
COPY target/java-servlet-web-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8082
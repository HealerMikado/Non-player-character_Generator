FROM tomcat:9-jdk11-openjdk

# Delete existing ROOT folder
RUN rm -rf /usr/local/tomcat/webapps/ROOT/

# Copy to images tomcat path
COPY /target/pnj_generator-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
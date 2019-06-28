FROM tomcat:9-jdk11-openjdk

# Delete existing ROOT folder
RUN rm -rf $CATALINA_HOME/webapps/*

# Copy to images tomcat path
COPY /target/pnj_generator-0.0.1-SNAPSHOT.war $CATALINA_HOME/webapps/ROOT.war
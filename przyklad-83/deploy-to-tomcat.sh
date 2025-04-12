WAR_NAME=$(ls 'target' | grep war | sed 's/\.war//')
TOMCAT_HOME=/Users/maciej/dev/bin/apache-tomcat-11.0.5

mvn clean install
cp "target/$WAR_NAME.war" "$TOMCAT_HOME/webapps"
open "http://localhost:8080/$WAR_NAME/"

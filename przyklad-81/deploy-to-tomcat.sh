WAR_NAME=$(ls 'target' | grep war | sed 's/\.war//')
TOMCAT_HOME=/Users/gowinm/dev/libs/apache-tomcat-9.0.89

mvn clean install
cp "target/$WAR_NAME.war" "$TOMCAT_HOME/webapps"
open "http://localhost:8080/$WAR_NAME/"

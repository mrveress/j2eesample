jenv local 21
mvn --version
mvn clean package

docker stop j2ee-sample-container
docker rm --volumes j2ee-sample-container

docker run \
    --name j2ee-sample-container \
    --expose 9871 -p 9871:8080 \
    -v ./target/j2eesample-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/ROOT.war \
    -d tomcat:11.0-jdk21-openjdk
    
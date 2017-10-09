FROM openjdk:8-jdk-alpine
EXPOSE 8090
VOLUME /tmp
ADD target/outsidr-1.0-SNAPSHOT.jar outsidr.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /outsidr.jar

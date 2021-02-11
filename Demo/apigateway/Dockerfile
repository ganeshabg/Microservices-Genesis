FROM adoptopenjdk/openjdk11:latest

RUN mkdir apigateway

COPY target/apigateway-1.0.jar /apigateway

EXPOSE 7070

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=minikube -jar /apigateway/apigateway-1.0.jar" ]
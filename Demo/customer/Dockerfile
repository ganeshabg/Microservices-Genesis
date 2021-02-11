FROM adoptopenjdk/openjdk11:latest

RUN mkdir customer

COPY target/customer-1.0.jar /customer

EXPOSE 7070

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=minikube -jar /customer/customer-1.0.jar" ]
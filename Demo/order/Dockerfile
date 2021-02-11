FROM adoptopenjdk/openjdk11:latest

RUN mkdir order

COPY target/order-1.0.jar /order

EXPOSE 7070

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=minikube -jar /order/order-1.0.jar" ]
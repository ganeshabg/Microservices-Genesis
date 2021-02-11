FROM adoptopenjdk/openjdk11:latest

RUN mkdir product

COPY target/product-1.0.jar /product

EXPOSE 7070

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=minikube -jar /product/product-1.0.jar" ]
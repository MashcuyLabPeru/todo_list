FROM openjdk:17-jdk-slim

WORKDIR /opt/app
ADD java-backend/target/java-backend-*.jar app.jar
EXPOSE 8000

ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar app.jar"]

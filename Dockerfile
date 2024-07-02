FROM openjdk:11-jre-slim

# Copia il JAR compilato nel container e rinominalo in proxy.jar
COPY target/proxy-0.0.1-SNAPSHOT.jar proxy.jar

# Copia il file properties nel container
COPY src/main/resources/application.properties application.properties

# Esponi la porta 8080
EXPOSE 8080

# Comando di avvio dell'applicazione
CMD ["java", "-Dspring.config.location=classpath:/,file:/application.properties", "-jar", "proxy.jar"]

# Usar una imagen base de Maven
FROM maven:3.8.4-openjdk-17

# Copiar los archivos del proyecto
COPY ./ /app

# Establecer el directorio de trabajo
WORKDIR /app

# Compilar el proyecto
RUN mvn clean package

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "target/cargo-0.0.1-SNAPSHOT.jar"]

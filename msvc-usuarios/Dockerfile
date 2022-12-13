#Imagen a copiar con SO Linux
FROM openjdk:17.0.2

#Carpeta de trabajo
WORKDIR /app

#Ruta dondde se encuentra el archivo rar con extension .jar EL PUNTO FINAL realiza el copy en la carpeta Wordir
COPY ./target/msvc-usuarios-0.0.1-SNAPSHOT.jar .

#Puerto del microservicio
EXPOSE 8000

#Levantar el contenedor - Punto de entrada - Codigo CMD cpara levanta la APP
ENTRYPOINT ["java", "-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]
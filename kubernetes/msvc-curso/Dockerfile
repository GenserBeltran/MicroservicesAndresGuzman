#Imagen a copiar con SO Linux
FROM openjdk:17-jdk-alpine as builder

#Carpeta de trabajo - PomParent/Carpeta de trabajo(Pom Principal)
WORKDIR /app/msvc-curso

# el ./ en los COPY es por que siempre se parte de la raiz -> Kubernetes

#Copiando el Poom Parent en app
COPY ./pom.xml /app
#Copiando carpetas del proyecto al cache una en su propia carpeta y otras en la raiz
COPY ./msvc-curso/.mvn ./.mvn
COPY ./msvc-curso/mvnw .
COPY ./msvc-curso/pom.xml .

#Adapta los flujos para la compilacion Jar y los comandos RUN
RUN sed -i 's/\r$//' mvnw

#Asignamos los comandos para que no genere o se salte carpetas de compilacion que agregar a SRC y que elimine la carpeta targe
RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

#COpiando lo que no esta en cache la carpeta SRC en un carpeta SRC del workid
COPY ./msvc-curso/src ./src

#Generando el Jar
RUN ./mvnw clean package -DskipTests

#Nueva Imagen
FROM openjdk:17-jdk-alpine

#carpeta de trabajo del prpoyecto
WORKDIR /app

#Copiando el jar de la construccion anterior
COPY --from=builder /app/msvc-curso/target/msvc-curso-0.0.1-SNAPSHOT.jar .

#Puerto del microservicio
ENV PORT 9000
EXPOSE $PORT

#Levantar el contenedor - Punto de entrada - Codigo CMD cpara levanta la APP
ENTRYPOINT ["java", "-jar", "msvc-curso-0.0.1-SNAPSHOT.jar"]

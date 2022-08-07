FROM eclipse-temurin:latest
ARG APPLICATION_JAR
ARG PORT
COPY $APPLICATION_JAR app.jar
ENV DEFAULT_ARGS "8080"
RUN echo $PORT
CMD ["/bin/bash", "-c", "java -jar app.jar ${PORT:-${DEFAULT_ARGS}}"]
EXPOSE "${PORT:-${DEFAULT_ARGS}}"
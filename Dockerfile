FROM amazoncorretto:17-alpine3.15
LABEL MANTAINER="FRETENET"

WORKDIR /app

EXPOSE 8083

RUN wget -O dd-java-agent.jar 'https://dtdg.co/latest-java-tracer'

ARG JAR_FILE=springframework/target/*.jar

COPY springframework/target/*.jar app.jar

ENTRYPOINT java -jar $JAVA_OPTS app.jar
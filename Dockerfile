FROM java:8-jdk-alpine
COPY ./build/libs/*.jar /usr/app/
WORKDIR /usr/app
ARG APP_NAME
ENV APP_NAME=${APP_NAME}
EXPOSE 8081
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /usr/app/${APP_NAME}.jar --docker.instanceId=${INSTANCE_ID}
FROM eclipse-temurin:17-alpine

# ENV MONGO_INITDB_ROOT_USERNAME=admin \
# 	MONGO_INITDB_ROOT_PASSWORD=password

RUN mkdir -p /home/app

WORKDIR /home/app

COPY target/*.jar ./app.jar

EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]
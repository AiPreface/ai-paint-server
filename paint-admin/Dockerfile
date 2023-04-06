FROM amazoncorretto:17.0.6-al2023
RUN echo "Asia/Shanghai" > /etc/timezone
MAINTAINER woxigousade
VOLUME /tmp
ADD target/paint-admin.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=prod","-jar","/app.jar"]
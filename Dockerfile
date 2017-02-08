FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/codeit.jar /codeit/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/codeit/app.jar"]

FROM openjdk:8-jdk-alpine
ENV TZ=Asia/Shanghai
COPY target/pxd-gateway.jar pxd-gateway.jar
ENTRYPOINT ["java","-Xms128m","-Xmx128m","-jar","/pxd-gateway.jar"]

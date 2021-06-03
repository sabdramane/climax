FROM openjdk:11-oraclelinux7

LABEL maintainer="sanouabdramane5@gmail.com"

VOLUME [ "/tmp" ]

EXPOSE 8181

ARG JAR_FILE=target/climax-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} climax.jar

ENTRYPOINT [ "java","-jar","/climax.jar" ]


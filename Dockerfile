FROM openjdk:8
ADD target/games-list.jar games-list.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "games-list.jar"]
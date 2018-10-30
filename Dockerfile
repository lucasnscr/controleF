FROM lucasnscr/git as clone (1)
WORKDIR /app
RUN git clone https://github.com/lucasnscr/controleF.git
FROM maven:3.5-jdk-8-alpine as build (2)
WORKDIR /app
COPY --from=clone /app/controleF /app (3)
RUN mvn install
FROM openjdk:8-jre-lucas
WORKDIR /app
COPY --from=build /app/target/controleF-1.0.0.jar /app
CMD ["java -jar controleF-1.0.0.jar"]

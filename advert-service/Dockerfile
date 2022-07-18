FROM openjdk:11-slim as build
COPY target/advert-service.jar advert-service.jar
RUN mkdir -p target/dependency && cd target/dependency &&  jar -xf /advert-service.jar

FROM openjdk:11-slim

VOLUME /tmp

#Copy unpackaged application to new container
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app


ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.advertservice.AdvertServiceApplication"]
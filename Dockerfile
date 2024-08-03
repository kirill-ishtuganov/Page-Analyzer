FROM gradle:8.5.0-jdk21

WORKDIR /app

COPY /app .

WORKDIR /app

RUN gradle installDist

EXPOSE 7070

CMD ./build/install/app/bin/app

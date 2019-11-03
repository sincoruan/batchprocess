# our base image
FROM java:latest

COPY batchprocess-0.0.1-SNAPSHOT.jar /usr/local/batchprocess/

WORKDIR /usr/local/batchprocess

# specify the port number the container should expose
EXPOSE 8081

# run the application
CMD ["java","-jar","batchprocess-0.0.1-SNAPSHOT.jar"]

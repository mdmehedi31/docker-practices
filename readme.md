


 ### Requirement of build a docker file (minimum)
 1. Base image
 2. Working directory
 3. Copy files
 4. Expose port : which my application run
 5. Startup command 

Added docker file in the root folder and added this configuration based on the requirements.

````
FROM eclipse-temurin

WORKDIR /app

COPY target/docker-practices-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# java jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
`````
Command: 

For build image
``docker build -t <docker image name> .`` 

For look images
```docker images```



For run images 
``docker run <image name with tag>``


Image will run but when you try to access any endpoint with will not reach to the docker image,
cause nothing is running on that port in you machine, the port is running in the docker,
so you need to make connection/pair with machine port and docker port, then you will access that endpoint from docker.

Here is the command
``docker run -p <machine port>:<docker port> <docker image name with tag>``
# Basic Springboot CORS test

### Start as default.

port: 8080

`$ ./mvnw package`

`java -jar -Dserver.port=8083 target/*.jar`

This should work:  `http://localhost:8080/client.html`

### Start a second server.

`$ ./mvnw package`

`java -jar -Dserver.port=8083 target/*.jar`

This should also work, even though it is a CORS call:  `http://localhost:8083/client.html`

This origin is in our whitelist.


### Start a third server.

`$ ./mvnw package`

`java -jar -Dserver.port=8084 target/*.jar`

This should fail, as it is not in our whitelist.

`http://localhost:8084/client.html`





### Cors configuration.

Cors has been set in the [WebSecurityConfig](src/main/java/com/example/cors/config/WebSecurityConfig.java)

The CORS settings have been externalized in the [./resource/cors.properties](src/main/resources/cors.properties) file using the following fields:

```properties
global.corssettings.allowedOrigins=http://localhost:8083,null
global.corssettings.allowedMethods=GET, POST
global.corssettings.registeredPath=/**
```
# Basic Springboot CORS test

### Start as default.

port: 8080

This should work:  `http://localhost:8080/client.html`

### Start as second server.

`$ ./mvnw package`

`java -jar -Dserver.port=8083 target\*.jar`

This should work:  `http://localhost:8083/client.html`


### Cors configuration.

Cors has been set in the [WebSecurityConfig](src/main/java/com/example/cors/config/WebSecurityConfig.java)
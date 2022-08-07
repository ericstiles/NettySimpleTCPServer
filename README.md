# NettySimpleTCPServer
A simple minimal Netty based demo TCP server.

Based on article:
* https://thebackendguy.medium.com/netty-simple-tcp-server-51fa8537fad5

# Running
```shell
$ java -jar ./target/NettySimpleTCPServer-shaed.jar 8080
```

# Docker

## Build

By default the Dockerfile set the port to 8080.

```shell
$ docker build --build-arg APPLICATION_JAR=./target/NettySimpleTCPServer-shaded.jar -t server .
```

## Run
### Example 1
```shell
$ docker run -p 8085:8082 server:latest

Attempting to run on port: 8080
Starting server at: 8080
Server started successfully
```
### Example 2
```shell
d run -p 8085:8082 --env PORT=8082 server

Attempting to run on port: 8082
Starting server at: 8082
Server started successfully
```

# Testing
1. Using example 1 above, start another terminal command and run the following
```shell
nc localhost 8085
```
2. Now type a message in the terminal
```shell
Great job!
```
3. See a response from the server
```shell
Great job!
Thanks
```
4. Check the logs
```shell
< /172.17.0.1:55478 > : Channel Active
< /172.17.0.1:55478 > : Great job server
```
5. Stop the netcat command and check the logs again
```shell
< /172.17.0.1:55478 > : Channel Inactive
```





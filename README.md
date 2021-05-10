# WebServer


## Installation

Run gradle build

```bash
.\gradlew.bat clean build
```
This will generate jar file under build\libs directory


## Usage

Run the Java jar file

```bash
java -jar build\libs\webserver-1.0-SNAPSHOT.jar
```
You will see startup lines

```bash
Starting app on directory: C:\Users\User\Projects\webserver
Starts web server on port: 80
```

Open web browser and load localhost

```bash
http://localhost
```

it will print the listing of application run directory e.g. C:\Users\User\Projects\webserver.

I prepared test directory [public/](public/) which contains [index.html](public/index.html). You can change into this directory before running the server to test how the webserver responds with html content by clicking index.html link when directory listing is loaded.


## Design decision

JDK/JRE: [Adopt OpenJDK v11 (OpenJ9)](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=openj9)

Due to limitation of using only standard Java SE 8:
1. Use combination of ServerSocket and BufferedReader to process incoming request to port 80.
2. Use combination of BufferedWriter and StringBuilder to generate response.
3. Build own HTTPStatus class using Map, currently only 200, 404 and 500 HTTP status included.


## Future improvements

1. Add configuration for port, serving directory.
2. Complete HTTP error status.
3. Add unit tests.
4. Use Threading and Non blocking IO.

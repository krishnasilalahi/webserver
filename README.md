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

Open web browser

```bash
http://localhost
```

it will print the listing of application run directory e.g. C:\Users\User\Projects\webserver.

I prepared test directory public/ which contains index.html. You can change into this directory before running the server to how the webserver response html content.

## Known issue

1. No configuration for port, serving directory
2. Missing tests

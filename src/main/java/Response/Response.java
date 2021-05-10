package Response;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Response {
    private String header;
    private String body;

    public Response() {
        this.header = "";
        this.body = "";
    }

    public void setHeader(String httpCode, String httpStatus) {
        header = new StringBuilder()
            .append("HTTP/1.0 ").append(httpCode).append(" ").append(httpStatus).append("\r\n")
            .append("Server: Main WebServer v0.1\r\n")
            .append("Content-Type: text/html\r\n")
            .append("\r\n")
            .toString();
    }

    public String getHeader() {
        return header;
    }

    public void setDirectoryBody(List<File> files, String requestPath) {
        StringBuilder temp = new StringBuilder()
            .append("<title>Directory list ")
            .append(requestPath)
            .append("</title>");

        if(requestPath.equals("/")) {
            requestPath = "";
        }
        String path = requestPath;

        files.forEach((file) -> {
            temp.append("<a href=\"")
                .append(path)
                .append("/")
                .append(String.valueOf(file))
                .append("\">")
                .append(String.valueOf(file))
                .append("</a><br />");
        });

        body = temp.toString();
    }

    public void setFileBody(File file) throws IOException {
        Scanner sc = new Scanner(file);
        StringBuilder temp = new StringBuilder();

        while (sc.hasNextLine()) {
            temp.append(sc.nextLine());
        }

        body = temp.toString();
    }

    public String getBody() {
        return body;
    }
}

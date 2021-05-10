package Request;

import java.util.List;

public class Request {
    private String method;
    private String fileRequest;
    private String httpVersion;
    private String host;
    private String port;
    private String body;

    public Request() {
        setMethod("GET");
        setFileRequest("/");
        setHttpVersion("HTTP/1.1");
        setHost("localhost");
        setPort("80");
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getFileRequest() { return fileRequest; }

    public void setFileRequest(String fileRequest) {
        this.fileRequest = fileRequest;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void parse(List<String> requestHeader) {
        String fileInfo = requestHeader.get(0);
        String[] fileInfoArr = fileInfo.split(" ");
        setMethod(fileInfoArr[0]);
        setFileRequest(fileInfoArr[1]);
        setHttpVersion(fileInfoArr[2]);

        String hostInfo = requestHeader.get(1);
        String[] hostInfoArr = hostInfo.split(" ");
        String[] hostArr = hostInfoArr[1].split(":");
        setHost(hostArr[0]);
        if(hostArr.length > 1 && !hostArr[1].isEmpty()) {
            setPort(hostArr[1]);
        }
    }

}

package Request;

import Response.HTTPStatus;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;

public class RequestProcessor {
    private static HTTPStatus httpStatuses;
    BufferedWriter out;
    Request request;

    public RequestProcessor(ServerSocket clientSocket) {
        this.request = new Request();
        httpStatuses = new HTTPStatus();
    }

    public void process(List<String> requestHeader) throws IOException {
    }
}

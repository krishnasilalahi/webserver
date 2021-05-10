import Directory.DirectoryProcessor;
import Request.Request;
import Response.HTTPStatus;
import Response.Response;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class WebServer {
    private final static Logger LOGGER = Logger.getLogger(WebServer.class.getName());
    private static HTTPStatus httpStatuses;

    public static void main(String[] args) throws Exception {
        int port = 80;
        String appDirectory = System.getProperty("user.dir");

        System.out.println("Starting app on directory: " + appDirectory);
        System.out.println("Starts web server on port: " + port);

        ServerSocket serverSocket = new ServerSocket(port);
        httpStatuses = new HTTPStatus();
        List<String> requestHeader;
        Request request = new Request();
        Response response = new Response();

        while (true) {
            Socket clientSocket = serverSocket.accept();
            requestHeader = new ArrayList<>();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String s;
            while ((s = in.readLine()) != null) {
//                System.out.println(s);
                requestHeader.add(s);
                if (s.isEmpty()) {
                    break;
                }
            }
            request.parse(requestHeader);

            File requestPath = new File(appDirectory.concat(request.getFileRequest()));
            if (!requestPath.exists()) {
                // return 404
                LOGGER.warning("File NOT FOUND");
                response.setHeader(
                    httpStatuses.getNotFoundCode(),
                    httpStatuses.getNotFoundStatus()
                );
                out.write(response.getHeader());
            }

            if (requestPath.isDirectory()) {
                // print directory
                LOGGER.info("Listing directory: " + requestPath);
                response.setHeader(
                    httpStatuses.getOKCode(),
                    httpStatuses.getOKStatus()
                );
                out.write(response.getHeader());
                List<File> files = DirectoryProcessor.getDirectoryList(requestPath.toString());
                response.setDirectoryBody(files, request.getFileRequest());
                out.write(response.getBody());
            } else if(requestPath.isFile()) {
                // print file content
                LOGGER.info("Printing file content");
                response.setHeader(
                    httpStatuses.getOKCode(),
                    httpStatuses.getOKStatus()
                );
                out.write(response.getHeader());
                response.setFileBody(requestPath);
                out.write(response.getBody());
            }

            System.out.println("Connection closed");
            out.close();
            in.close();
            clientSocket.close();
        }
    }

}

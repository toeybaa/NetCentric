package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws Exception {
        TestServer server = new TestServer();
        server.run();
    }

    public void run() throws Exception {
        ServerSocket serverSocket = new ServerSocket(3322);
        Socket socket = serverSocket.accept(); // listen for connection, then accept
        // it.
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // get data from client

        String message = bufferedReader.readLine();
        System.out.println(message); // show what you get from client.
        if (message != null) {
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println("Server: message received."); // send confirmation to client.
            // SevSock.close(); //close socket.
        }
    }

}
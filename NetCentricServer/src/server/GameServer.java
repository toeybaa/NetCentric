package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by peth on 11/5/2015 AD.
 */
public class GameServer implements Runnable {
    BufferedReader incomingData;
    PrintStream outgoingData;
    ServerSocket serverSocket;
    private int tries;
    private int port;

    public GameServer(int port) {
        this.port = port;
        initialize();
    }

    private void initialize() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("Error initializing server!");
            e.printStackTrace();
            System.err.println("Retrying... (" + tries++ + ")");
            if (tries < 5) {
                initialize();
            } else {
                System.err.println("Maximum number of tries reached! Failed to initialize server!");
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Starting GameServer on port " + port + "...");
        Socket socket = null;
        try {
            socket = serverSocket.accept();
            incomingData = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outgoingData = new PrintStream(socket.getOutputStream());
            System.out.println("Started server on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                String message = incomingData.readLine();
                System.out.println(message);
            } catch (IOException e) {
                System.err.println("Error reading incoming data!");
                e.printStackTrace();
            }
        }
    }
}

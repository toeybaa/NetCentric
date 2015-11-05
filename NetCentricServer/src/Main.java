import server.GameServer;

/**
 * Created by peth on 11/5/2015 AD.
 */
public class Main {
    public static void main(String[] args) {
        Runnable gameServer = new GameServer(3322);
        Thread gameServerThread = new Thread(gameServer);
        gameServerThread.start();
    }
}

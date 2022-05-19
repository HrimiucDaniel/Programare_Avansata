import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    public Server() throws IOException {
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);
            serverSocket.setReuseAddress(true);
            while (true) {
               System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                socket.setSoTimeout(60000);
                ClientThread clientThread = new ClientThread(socket);
                // Execute the client's request in a new thread
                new Thread(clientThread).start();
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }

}
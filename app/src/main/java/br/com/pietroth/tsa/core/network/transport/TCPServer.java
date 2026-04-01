package br.com.pietroth.tsa.core.network.transport;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class TCPServer implements Server {
    private final int port;
    private final ExecutorService clientPool;

    public TCPServer(int port, ExecutorService clientPool) {
        this.port = port;
        this.clientPool = clientPool;
    }

    @Override
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());
                clientPool.submit(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {
        System.out.println("Stopping TCP Server...");
    }
}
 
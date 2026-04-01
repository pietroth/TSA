package br.com.pietroth.tsa.core.network.transport;

public class TCPServer implements Server {

    @Override
    public void start() {
        System.out.println("Starting TCP Server...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping TCP Server...");
    }
}
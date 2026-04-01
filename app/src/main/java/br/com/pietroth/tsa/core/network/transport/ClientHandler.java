package br.com.pietroth.tsa.core.network.transport;

public class ClientHandler implements Runnable {
    private final java.net.Socket clientSocket;

    public ClientHandler(java.net.Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(clientSocket.getInputStream()));
             java.io.PrintWriter out = new java.io.PrintWriter(clientSocket.getOutputStream(), true)) {

            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received from client: " + request);
                out.println("Echo: " + request);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }
}
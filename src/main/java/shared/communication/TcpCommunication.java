package main.java.shared.communication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;
import java.util.function.Consumer;

public class TcpCommunication {


    private final String host;
    private final int port;

    public TcpCommunication(final String host, final int port) throws Exception
    {
        this.host = host;
        this.port = port;
    }

    public void send(final String message) throws IOException {

        final var client = new Socket(host, port);
        final var out = new DataOutputStream(client.getOutputStream());
        out.writeBytes(message);
        client.close();
    }

    public void listen(final Consumer<String> whenReceiveMessage) throws IOException {

        final var server = new ServerSocket(port);
        final var connectionSocket = server.accept();
        final var inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
        final var message = inFromClient.readLine();
        whenReceiveMessage.accept(message);
        server.close();
    }
}

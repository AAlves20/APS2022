package main.java.server;

import main.java.hepers.PromptWriter;
import main.java.shared.communication.TcpCommunication;

public class Main {
    public static void main(String[] argv) throws Exception {

        final var tcpCommunication = new TcpCommunication("localhost", 6789);

        PromptWriter.writeLine("Bem vindo ao servidor de message");
        PromptWriter.writeLine("Aguarde, enquanto as messagens sao enviadas");

        while (true) {
            tcpCommunication.listen(message -> PromptWriter.writeLine("Voce recebeu uma nova mensagem: " + message));
        }
    }
}

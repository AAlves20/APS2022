package main.java.client;

import main.java.hepers.PromptWriter;
import main.java.shared.communication.TcpCommunication;

public class Main {

    public static void main(String[] args) throws Exception {
        final var tcpCommunication = new TcpCommunication("localhost", 6789);

        PromptWriter.writeLine("Bem vindo ao servico de mensagens");
        PromptWriter.writeLine("Aguarde, Aqui voce pode enviar mensagens");


        while (true) {
            PromptWriter.writeLine("Por favor digite sua mensagem abaixo");
            final var message = PromptWriter.readLine();
            tcpCommunication.send(message);
            PromptWriter.writeLine("Mensagem enviada com sucesso...");
        }

    }
}
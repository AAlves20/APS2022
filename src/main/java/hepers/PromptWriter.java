package main.java.hepers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PromptWriter {

    public static String readLine() throws IOException {
        final var messageFromUser = new BufferedReader(new InputStreamReader(System.in));
        return messageFromUser.readLine();
    }

    public static void writeLine(final String message) {
        System.out.println(message);
    }

}

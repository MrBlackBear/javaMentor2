package main.multithreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Main {
    public static final int PORT = 5050;
    private static Logger logger = Logger.getLogger(Main.class.toString());

    public static void main(String[] args) throws IOException {
        logger.info("Server started");
        try (ServerSocket s = new ServerSocket(PORT)) {
            while (true) {
                final Socket socket = s.accept();
                new Thread(new RepeatServer(socket));
            }
        }
    }
}

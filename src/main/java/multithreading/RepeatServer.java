package main.multithreading;

import java.io.*;
import java.net.Socket;

public class RepeatServer extends Thread {
    private final Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public RepeatServer(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(
                new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                String str = in.readLine();
                if (str.equals("Bye.")) {
                    socket.close();
                    break;
                } else {
                    out.println(str);
                }
            }
        } catch (IOException e) {
            System.err.println("IO Exception");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}

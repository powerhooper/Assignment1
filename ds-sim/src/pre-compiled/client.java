import java.net.*;
import java.io.*;

public class client {
     public static void main(String[] args) {
        try {
            int port = 52404; // Change to be unique (use last 4 digits of ID)
            Socket clientSocket = new Socket("127.0.0.1", port);
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String sendHello = "HELO";
            System.out.println(String.format("Sending: %s", sendHello));
            writer.println(sendHello);
            String receivedHello = reader.readLine();
            System.out.println(String.format("Received: %s", receivedHello));

            String sendAuth = "AUTH 47232404" ;
            System.out.println(String.format("Sending: %s", sendAuth));
            writer.println(sendAuth);
            String receivedAuth = reader.readLine();
            System.out.println(String.format("Received: %s", receivedAuth));

            String sendRedy = "REDY" ;
            System.out.println(String.format("Sending: %s", sendRedy));
            writer.println(sendAuth);
            String receivedRedy = reader.readLine();
            System.out.println(String.format("Received: %s", receivedRedy));

            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

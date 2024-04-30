import java.io.*;
import java.net.*;

// Server program
public class MyServer {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server is waiting for a connection...");
            
            // Accept client connection
            Socket s = ss.accept();
            System.out.println("Client connected!");

            // Create input stream to read data from the client
            DataInputStream dis = new DataInputStream(s.getInputStream());

            // Read the initial message from the client
            String clientMessage = dis.readUTF();
            System.out.println("Program Name: " + clientMessage);
            
            // Read the roll number from the client
            String clientMessage1 = dis.readUTF();
            System.out.println("Roll Number: " + clientMessage1);

            // Read additional parameters sent by the client
            String additionalData = dis.readUTF();
            System.out.println("Message Received: " + additionalData);

            // Close resources
            dis.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

// Client program
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket s = new Socket("localhost", 6666);

            // Create output stream to send data to the server
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Send program name to the server
            dout.writeUTF("Server & Client");

            // Read roll number from user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your Roll: ");
            String userMessage = scanner.nextLine();
            dout.writeUTF(userMessage);
            dout.flush();

            // Send additional parameters to the server
            String additionalData = "Your additional data here"; // Replace with actual data
            dout.writeUTF(additionalData);
            dout.flush();

            // Close resources
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

// UDP Client
public class UDPClient {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte[] buf;
        
        // Continuous input loop
        while (true) {
            String input = sc.nextLine();
            buf = input.getBytes();
            
            // Sending data to the server
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);
            ds.send(DpSend);
            
            // Check if client wants to terminate
            if (input.equals("bye"))
                break;
        }
        sc.close();
        ds.close();
    }
}
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// UDP Server
public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] receiveData = new byte[65535];
        DatagramPacket DpReceive;

        while (true) {
            // Receiving data from the client
            DpReceive = new DatagramPacket(receiveData, receiveData.length);
            ds.receive(DpReceive);

            // Displaying received data
            System.out.println("Client: " + data(receiveData));

            // Check if client wants to terminate
            if (data(receiveData).toString().equals("bye")) {
                System.out.println("Client sent bye... Exiting");
                break;
            }

            receiveData = new byte[65535]; // Reset receive buffer
        }
        ds.close();
    }

    // Utility method to convert byte array to string
    public static StringBuilder data(byte[] a) {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0) {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }
}

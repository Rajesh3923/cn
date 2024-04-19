import java.util.Date;
import java.util.Scanner;
public class lab5 {
  public static void main(String[] args) throws InterruptedException {
    // Variable declarations
    int n, seq, ack = 0, j = 0;
    Scanner scanner = new Scanner(System.in);
    // User input: number of frames
    System.out.println("Enter the number of frames: ");
    n = scanner.nextInt();
    scanner.nextLine(); // Consume newline
    // Array to store frame data
    String[] f = new String[n];
    // Frame transmission loop
    for (int i = 0; i < n; i++) {
      ack = 0;
      // User input: sequence number
      System.out.println("Enter sequence number:");
      seq = scanner.nextInt();
      scanner.nextLine(); // Consume newline
      // User input: frame data
      System.out.println("Enter frame:");
      f[i] = scanner.nextLine();
      // Simulating frame acknowledgment
      ack = 1;
      // Getting and printing local time
      Date currentDate = new Date();
      System.out.println(currentDate);
      // Simulating a delay of 5 seconds
      Thread.sleep(5000);
      // Getting and printing local time after the delay
      currentDate = new Date();
      System.out.println(currentDate);
      // Displaying received frame information
      System.out.println("Received " + seq + " frame");
    }
    // Printing the frames received
    for (j = 0; j < f.length; j++) {
      System.out.print(f[j]+" ");
    }
    // Close the scanner
    scanner.close();
  }
}

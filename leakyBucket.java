import java.util.Random;
import java.util.Scanner;
public class BucketAlgorithm {
    static final int bucketSize = 512;
    static void bktInput(int a, int b) {
        if (a > bucketSize)
            System.out.println("\n\t\tBucket overflow");
        else {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (a > b) {
                System.out.println("\n\t\t bytes outputted.");
                a -= b;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (a > 0)
                System.out.printf("\n\t\tLast %d bytes sent\t", a);
            System.out.println("\n\t\tBucket output successful");
        }
    }
    public static void main(String[] args) {
        Random rand = new Random();
        int op, pktSize;
        System.out.print("Enter output rate : ");
        // Assuming you're using Scanner for user input
        Scanner scanner = new Scanner(System.in);
        op = scanner.nextInt();
        // op = 100; // Example value for testing
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pktSize = rand.nextInt();
            System.out.printf("\nPacket no:%d \tPacket size:%d ", i, pktSize);
            bktInput(pktSize, op);
        }
    }
}

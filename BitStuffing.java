import java.util.Scanner;
public class BitStuffing {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter input bit sequence: ");
    String input = scanner.nextLine();
    String stuffedSequence = stuffBits(input);
    String destuffedSequence = destuffBits(stuffedSequence);
    System.out.println("Output");
    System.out.println(" ------ ");
    System.out.println("Stuffed Bit Sequence is: " + stuffedSequence);
    System.out.println("Destuffed Bit Sequence is: " + destuffedSequence);
    scanner.close();
  }
  public static String stuffBits(String input) {
    StringBuilder stuffedSequence = new StringBuilder();
    int count = 0;
    for (int i = 0; i < input.length(); i++) {
      stuffedSequence.append(input.charAt(i));
      if (input.charAt(i) == '1') {
        count++;
      } else {
        count = 0;
      }
      if (count == 5) {
        stuffedSequence.append('0');
        count = 0;
      }
    }
    return "01111110" + stuffedSequence.toString() + "01111110";
  }
  public static String destuffBits(String input) {
    StringBuilder destuffedSequence = new StringBuilder();
    int j = 8, five = 0; // Start from index 8 to skip the preamble
    int len_op = input.length();
    while (j < len_op - 8) { // Stop before the ending flag sequence
      destuffedSequence.append(input.charAt(j));
      if (input.charAt(j) == '1') {
        five++;
      } else {
        five = 0;
      }
      if (five == 5) {
        j++; // Skip the stuffed '0'
        five = 0;
      }
      j++;
    }
    return destuffedSequence.toString();
  }
}

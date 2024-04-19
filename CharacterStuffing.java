import java.util.Scanner;
public class CharacterStuffing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter plain text: ");
        String source = scanner.nextLine();
        String stuffedData = characterStuffing(source);
        System.out.println("After character stuffing: " + stuffedData);
        String destuffedData = characterDestuffing(stuffedData);
        System.out.println("After character destuffing: " + destuffedData);
        scanner.close();
    }
    public static String characterStuffing(String source) {
        StringBuilder stuffedData = new StringBuilder();
        stuffedData.append("dlestx");
        for (int k = 0; k < source.length(); ) {
            if (source.charAt(k) == 'd' && k + 2 < source.length() && source.substring(k, k + 3).equals("dle")) {
                stuffedData.append("dle");
                stuffedData.append("dle");
                k += 3;
            } else {
                stuffedData.append(source.charAt(k++));
            }
        }
        stuffedData.append("dlestx");
        return stuffedData.toString();
    }
    public static String characterDestuffing(String stuffedData) {
        StringBuilder destuffedData = new StringBuilder();
        // int j = 0;
        for (int i = 6; i < stuffedData.length() - 6;) {
            if (stuffedData.charAt(i) == 'd' && i + 2 < stuffedData.length() && stuffedData.substring(i, i + 3).equals("dle")) {
                destuffedData.append("dle");
                i = i + 6;
            } else {
                destuffedData.append(stuffedData.charAt(i++));
            }
        }
        return destuffedData.toString();
    }
}

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger K = scanner.nextBigInteger();
        int L = scanner.nextInt();
        scanner.close();

        System.out.println(isGoodPassword(K, L));
    }

    private static String isGoodPassword(BigInteger K, int L) {
        for (int i = 2; i < L; i++) {
            if (K.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                return "BAD " + i;
            }
        }
        return "GOOD";
    }
}

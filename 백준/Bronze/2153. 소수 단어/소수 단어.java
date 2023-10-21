import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String word = br.readLine();
        int num = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 97) num += ch - 96;
            else num += ch - 38;
        }
        System.out.println(isPrime(num) ? "It is a prime word." : "It is not a prime word.");
    }

    static boolean isPrime(int num) {
        if (num == 1) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

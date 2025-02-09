import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append(" ");
        }
        String allInput = sb.toString().trim();

        if (allInput.isEmpty()) {
            System.out.println(0);
            return;
        }
        String[] tokens = allInput.split("\\s+");
        if (tokens.length != 3) {
            System.out.println(0);
            return;
        }

        for (String token : tokens) {
            if (!isValidFormat(token)) {
                System.out.println(0);
                return;
            }
        }

        int n, a, b;
        try {
            n = Integer.parseInt(tokens[0]);
            a = Integer.parseInt(tokens[1]);
            b = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            System.out.println(0);
            return;
        }

        if (n <= 3 || n > 1000000000 || n % 2 != 0) {
            System.out.println(0);
            return;
        }

        if (a + b != n) {
            System.out.println(0);
            return;
        }

        if (!isPrime(a) || !isPrime(b)) {
            System.out.println(0);
            return;
        }

        System.out.println(1);
    }

    private static boolean isValidFormat(String token) {
        if (token.isEmpty()) return false;
        for (int i = 0; i < token.length(); i++) {
            if (!Character.isDigit(token.charAt(i))) {
                return false;
            }
        }
        return token.length() == 1 || token.charAt(0) != '0';
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

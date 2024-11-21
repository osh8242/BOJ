import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isMystical(i)) count++;
        }
        System.out.println(count);

    }

    static boolean isMystical(int n) {
        String str = String.valueOf(n);
        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += c;
        }
        return n % (sum - str.length() * '0') == 0;
    }
}

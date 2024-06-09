import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String line = br.readLine().toLowerCase();
            sb.append(isPalindrome(line) ? "Yes" : "No").append("\n");
        }
        System.out.println(sb);
    }

    static boolean isPalindrome(String line) {
        for (int i = 0; i < line.length() / 2; i++) {
            if (line.charAt(i) != line.charAt(line.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}

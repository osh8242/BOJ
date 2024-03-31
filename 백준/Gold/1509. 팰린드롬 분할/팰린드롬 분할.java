import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int N = chars.length;
        boolean[][] isPalindrome = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < N - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                isPalindrome[i][i + 1] = true;
            }
        }
        for (int j = 2; j < N; j++) {
            for (int i = 0; i < N - 2; i++) {
                if (chars[i] == chars[j] && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int idx = 0; idx < N; idx++) {
            if (isPalindrome[0][idx]) {
                dp[idx] = 1;
                continue;
            }
            for (int s = 1; s <= idx; s++) {
                if (isPalindrome[s][idx]) {
                    dp[idx] = Math.min(dp[idx], dp[s - 1] + 1);
                }
            }
        }
        System.out.println(dp[N - 1]);
    }
}
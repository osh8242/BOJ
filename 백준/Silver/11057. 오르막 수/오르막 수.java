import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int N;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++) dp[0][i] = 1;
        findAscendingNumbers();
        System.out.println(dp[N][0]);
    }

    static void findAscendingNumbers() {
        for (int i = 1; i < N + 1; i++) {
            dp[i][9] = 1;
            for (int j = 8; j >= 0; j--) {
                dp[i][j] = dp[i-1][j] + dp[i][j+1];
                dp[i][j] %= 10007;
            }
        }
    }
}
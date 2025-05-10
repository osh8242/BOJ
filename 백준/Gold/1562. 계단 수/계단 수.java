import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int FULL = (1 << 10) - 1;
        int[][] dp = new int[10][1 << 10];
        for (int d = 1; d <= 9; d++) {
            dp[d][1 << d] = 1;
        }
        for (int len = 2; len <= N; len++) {
            int[][] nextDp = new int[10][1 << 10];
            for (int d = 0; d <= 9; d++) {
                for (int mask = 0; mask <= FULL; mask++) {
                    int val = dp[d][mask];
                    if (val == 0) continue;
                    if (d > 0) {
                        int nm = mask | (1 << (d - 1));
                        nextDp[d - 1][nm] = (nextDp[d - 1][nm] + val) % MOD;
                    }
                    if (d < 9) {
                        int nm = mask | (1 << (d + 1));
                        nextDp[d + 1][nm] = (nextDp[d + 1][nm] + val) % MOD;
                    }
                }
            }
            dp = nextDp;
        }
        long ans = 0;
        for (int d = 0; d <= 9; d++) {
            ans = (ans + dp[d][FULL]) % MOD;
        }
        System.out.println(ans);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[] a = new int[N+1];
        String[] parts = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(parts[i-1]);
        }

        int[][] dp = new int[M+1][N+1];
        for (int t = 0; t <= M; t++) {
            Arrays.fill(dp[t], -1);
        }
        dp[0][0] = 1;
        int ans = 1;

        for (int t = 0; t < M; t++) {
            for (int i = 0; i <= N; i++) {
                if (dp[t][i] < 0) continue;
                int cur = dp[t][i];
                // 1칸 굴리기
                if (i + 1 <= N) {
                    int nxt = cur + a[i+1];
                    if (nxt > dp[t+1][i+1]) {
                        dp[t+1][i+1] = nxt;
                        ans = Math.max(ans, nxt);
                    }
                }
                // 2칸 던지기
                if (i + 2 <= N) {
                    int nxt = (cur / 2) + a[i+2];
                    if (nxt > dp[t+1][i+2]) {
                        dp[t+1][i+2] = nxt;
                        ans = Math.max(ans, nxt);
                    }
                }
                // 이미 끝에 도달했으면 크기 유지
                if (i == N) {
                    if (cur > dp[t+1][N]) {
                        dp[t+1][N] = cur;
                        ans = Math.max(ans, cur);
                    }
                }
            }
        }

        System.out.print(ans);
    }
}

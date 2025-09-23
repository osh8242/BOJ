import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int MAX = C + 100;
        int[] dp = new int[MAX + 1];
        Arrays.fill(dp, 1_000_000_000);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int cust = Integer.parseInt(st.nextToken());
            for (int j = cust; j <= MAX; j++) {
                if (dp[j - cust] + cost < dp[j]) dp[j] = dp[j - cust] + cost;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = C; i <= MAX; i++) ans = Math.min(ans, dp[i]);
        StringBuilder sb = new StringBuilder();
        sb.append(ans);
        System.out.print(sb.toString());
    }
}

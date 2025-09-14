import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        int[] Rs = new int[T];
        int[] Cs = new int[T];
        int maxR = 0, maxC = 0;
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            Rs[t] = R;
            Cs[t] = C;
            if (R > maxR) maxR = R;
            if (C > maxC) maxC = C;
        }
        long[][] dp = new long[maxR + 1][maxC + 1];
        for (int r = 1; r <= maxR; r++) dp[r][1] = 1;
        for (int c = 1; c <= maxC; c++) dp[1][c] = 1;
        for (int r = 2; r <= maxR; r++) {
            for (int c = 2; c <= maxC; c++) {
                dp[r][c] = dp[r - 1][c] + dp[r][c - 1];
            }
        }
        for (int i = 0; i < T; i++) {
            sb.append("Case #").append(i + 1).append(": ").append(dp[Rs[i]][Cs[i]]).append('\n');
        }
        System.out.print(sb.toString());
    }
}

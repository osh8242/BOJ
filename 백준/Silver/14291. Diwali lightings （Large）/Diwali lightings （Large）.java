import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            String S = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            long I = Long.parseLong(st.nextToken());
            long J = Long.parseLong(st.nextToken());
            int L = S.length();
            long[] prefix = new long[L + 1];
            for (int i = 1; i <= L; i++) {
                prefix[i] = prefix[i - 1] + (S.charAt(i - 1) == 'B' ? 1 : 0);
            }
            long totalB = prefix[L];
            sb.append("Case #").append(tc).append(": ")
              .append(countUpTo(J, L, totalB, prefix) - countUpTo(I - 1, L, totalB, prefix))
              .append('\n');
        }
        System.out.print(sb.toString());
    }

    private static long countUpTo(long x, int L, long totalB, long[] prefix) {
        if (x <= 0) return 0;
        long full = x / L;
        int rem = (int)(x % L);
        return full * totalB + prefix[rem];
    }
}

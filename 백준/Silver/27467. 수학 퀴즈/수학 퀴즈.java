import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long c0 = 0, c1 = 0, c2 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int r = (int)(a % 3);
            if (r == 0) c0++;
            else if (r == 1) c1++;
            else c2++;
        }
        long p = c1 - c2;
        long q = c0 - c2;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(java.util.Locale.US, "%.9f %.9f", (double)p, (double)q));
        System.out.println(sb.toString());
    }
}

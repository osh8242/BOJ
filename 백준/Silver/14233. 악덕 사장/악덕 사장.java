import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        long[] a = new long[n];
        int idx = 0;
        StringTokenizer st = null;
        while (idx < n) {
            String line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);
            while (st.hasMoreTokens() && idx < n) {
                a[idx++] = Long.parseLong(st.nextToken());
            }
        }
        Arrays.sort(a);
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long val = a[i] / (i + 1);
            if (val < ans) ans = val;
        }
        if (ans == Long.MAX_VALUE) ans = 0;
        System.out.println(ans);
    }
}

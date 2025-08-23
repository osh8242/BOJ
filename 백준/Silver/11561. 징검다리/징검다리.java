import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            long N = Long.parseLong(br.readLine().trim());
            long lo = 0, hi = 200000000; 
            while (lo < hi) {
                long mid = (lo + hi + 1) >>> 1;
                if (safeSum(mid) <= N) lo = mid;
                else hi = mid - 1;
            }
            sb.append(lo).append('\n');
        }
        System.out.print(sb.toString());
    }
    static long safeSum(long k) {
        return k * (k + 1) / 2;
    }
}

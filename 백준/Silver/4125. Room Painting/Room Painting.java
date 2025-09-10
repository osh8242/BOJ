import java.io.*;
import java.util.*;

public class Main {
    static int lowerBound(long[] a, long key) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (a[mid] >= key) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] cans = new long[n];
        for (int i = 0; i < n; i++) {
            cans[i] = Long.parseLong(br.readLine().trim());
        }
        Arrays.sort(cans);
        long waste = 0L;
        for (int i = 0; i < m; i++) {
            long need = Long.parseLong(br.readLine().trim());
            int idx = lowerBound(cans, need);
            long chosen = cans[idx];
            waste += (chosen - need);
        }
        System.out.println(waste);
    }
}

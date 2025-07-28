import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int z = Integer.parseInt(br.readLine().trim());
        while (z-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            long[] t = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                t[i] = Long.parseLong(st.nextToken());
            }
            Arrays.sort(t);
            long total = 0;
            for (long v : t) total += v;
            long silverMax = 0;
            long sumSilver = 0;
            for (int i = n - 1; i >= n - k; i--) {
                if (i < 0) break;
                sumSilver += t[i];
                silverMax = Math.max(silverMax, t[i]);
            }
            long goldSum = total - sumSilver;
            long ans = Math.max(silverMax, goldSum);
            System.out.println(ans);
        }
    }
}

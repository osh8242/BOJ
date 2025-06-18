import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static long countZerosUpTo(long x) {
        if (x <= 0) return 0;
        long count = 0;
        for (long factor = 1; factor <= x; factor *= 10) {
            long high = x / (factor * 10);
            long curr = (x / factor) % 10;
            long low = x % factor;
            if (curr == 0) {
                count += (high - 1) * factor + (low + 1);
            } else {
                count += high * factor;
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] sp = br.readLine().split(" ");
            int N = Integer.parseInt(sp[0]);
            int M = Integer.parseInt(sp[1]);
            long ans;
            if (N == 0) {
                ans = countZerosUpTo(M) + 1;
            } else {
                ans = countZerosUpTo(M) - countZerosUpTo(N - 1);
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}

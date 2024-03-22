import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int answer = 0;
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ni = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            int e = (int) ((si * getPow(ni, MOD-2)) % MOD);
            answer = (answer + e) % MOD;
        }
        System.out.println(answer);
    }

    static long getPow(int b, int p) {
        if (p == 1) return b;
        long halfPow = getPow(b, p / 2);
        long result = halfPow * halfPow % MOD;
        if (p % 2 == 1) result *= b;
        return result % MOD;
    }
}

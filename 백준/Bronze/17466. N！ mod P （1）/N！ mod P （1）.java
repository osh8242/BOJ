import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long res;
        if (N == P - 1) {
            res = P - 1;
        } else {
            long k = P - 1 - N;
            if (N <= k) {
                res = 1;
                for (long i = 1; i <= N; i++) {
                    res = (res * i) % P;
                }
            } else {
                long denom = 1;
                for (long i = N + 1; i <= P - 1; i++) {
                    denom = (denom * i) % P;
                }
                long inv = modExp(denom, P - 2, P);
                res = ((P - 1) * inv) % P;
            }
        }
        System.out.println(res);
    }

    static long modExp(long a, long e, long mod) {
        long result = 1;
        a %= mod;
        while (e > 0) {
            if ((e & 1) == 1) result = (result * a) % mod;
            a = (a * a) % mod;
            e >>= 1;
        }
        return result;
    }
}
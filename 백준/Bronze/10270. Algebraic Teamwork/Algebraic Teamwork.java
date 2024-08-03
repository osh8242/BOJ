import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    private static final int MOD = 1000000007;
    private static final int MAX_N = 100000;
    private static final long[] factorials = new long[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        precomputeFactorials();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long result = (factorials[n] - 1 + MOD) % MOD;
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void precomputeFactorials() {
        factorials[0] = 1;
        for (int i = 1; i <= MAX_N; i++) {
            factorials[i] = factorials[i - 1] * i % MOD;
        }
    }
}

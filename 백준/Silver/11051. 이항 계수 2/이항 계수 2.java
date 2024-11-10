import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 10007;

    static int[][] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        values = new int[N + 1][K + 1];

        System.out.println(getCombination(N,K));
    }

    static int getCombination(int n, int k) {
        if (k == 0 || k == n) return 1;
        if(values[n][k] != 0) return values[n][k];
        values[n][k] = (getCombination(n - 1, k) + getCombination(n - 1, k - 1)) % MOD;
        return values[n][k];
    }
}

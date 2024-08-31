import java.io.*;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int p = Math.abs(n);
        bw.write(n < 0 && n % 2 == 0 ? "-1" : n == 0 ? "0" : "1");
        bw.newLine();
        bw.write(Integer.toString(fibonacci(p)));
        bw.flush();
    }

    static int fibonacci(int p) {
        if (p <= 1) return p;
        long[][] F = {{1, 1}, {1, 0}};
        pow(F, p - 1);
        return (int) F[0][0];
    }

    static void pow(long[][] A, int p) {
        if (p <= 1) return;
        pow(A, p / 2);
        multiply(A, A);
        if (p % 2 != 0) multiply(A, new long[][]{{1, 1}, {1, 0}});
    }

    static void multiply(long[][] A, long[][] B) {
        long x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        long y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        long z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        long w = A[1][0] * B[0][1] + A[1][1] * B[1][1];
        A[0][0] = x % MOD;
        A[0][1] = y % MOD;
        A[1][0] = z % MOD;
        A[1][1] = w % MOD;
    }
}

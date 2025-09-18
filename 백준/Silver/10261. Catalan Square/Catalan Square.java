import java.io.*;
import java.math.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int m = n + 1;
        int N = 2 * m;
        int k = m;
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= k; i++) {
            res = res.multiply(BigInteger.valueOf(N - k + i));
            res = res.divide(BigInteger.valueOf(i));
        }
        res = res.divide(BigInteger.valueOf(m + 1));
        StringBuilder sb = new StringBuilder();
        sb.append(res.toString()).append('\n');
        System.out.print(sb.toString());
    }
}

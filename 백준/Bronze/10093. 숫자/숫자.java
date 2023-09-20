import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());
        int n = Math.abs(B.subtract(A).intValue());
        if (n == 1 || n == 0) {
            System.out.println(0);
            return;
        }
        sb.append(n - 1).append("\n");
        BigInteger C = A.min(B);
        for (int i = 1; i < n; i++) {
            C = C.add(BigInteger.ONE);
            sb.append(C).append(" ");
        }
        System.out.println(sb);
    }

}

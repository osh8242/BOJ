import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            br.readLine();
            int N = Integer.parseInt(br.readLine());
            BigInteger bigInteger = BigInteger.ZERO;
            for (int i = 1; i <= N; i++) {
                bigInteger = bigInteger.add(new BigInteger(br.readLine()));
            }
            sb.append(bigInteger.divideAndRemainder(new BigInteger(String.valueOf(N)))[1].compareTo(BigInteger.ZERO) == 0 ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}

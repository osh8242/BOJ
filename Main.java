import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            BigInteger bigInteger = new BigInteger(br.readLine());
            sb.append(bigInteger.mod(BigInteger.TWO).equals(BigInteger.ZERO) ? "even" : "odd").append("\n");
        }
        System.out.println(sb);
    }

}

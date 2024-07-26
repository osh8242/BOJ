import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder sb = new StringBuilder();

            String input;
            while (!(input = br.readLine()).equals("0")) {
                BigInteger value = new BigInteger(input);
                value = getDigitalRoot(value);
                sb.append(value).append("\n");
            }

            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static BigInteger getDigitalRoot(BigInteger value) {
        while (value.compareTo(BigInteger.TEN) >= 0) {
            BigInteger sum = BigInteger.ZERO;
            while (value.compareTo(BigInteger.ZERO) > 0) {
                sum = sum.add(value.mod(BigInteger.TEN));
                value = value.divide(BigInteger.TEN);
            }
            value = sum;
        }
        return value;
    }
}

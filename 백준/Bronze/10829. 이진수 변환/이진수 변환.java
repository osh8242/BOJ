import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger N = new BigInteger(br.readLine());
        System.out.println(getBinaryValue(N));
    }

    static String getBinaryValue(BigInteger N){
        StringBuilder result = new StringBuilder();
        while(!N.equals(BigInteger.ZERO)){
            result.insert(0, N.remainder(BigInteger.TWO));
            N = N.divide(BigInteger.TWO);
        }
        return result.toString();
    }
}
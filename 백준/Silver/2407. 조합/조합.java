import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger answer = BigInteger.ONE;
        int divisor = 1;
        for(int i = n ; i > n-m ; i--){
            answer = answer.multiply(new BigInteger(String.valueOf(i)));
        }
        while(++divisor <= m){
            answer = answer.divide(new BigInteger(String.valueOf(divisor)));
        }
        System.out.println(answer.toString());
    }

}

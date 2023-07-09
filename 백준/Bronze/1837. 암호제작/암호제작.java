import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger p = new BigInteger(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 2 ; i < k ; i++){
            BigInteger divisor = BigInteger.valueOf(i);
            if(p.mod(divisor).equals(BigInteger.ZERO)){
                System.out.println("BAD " + i);
                return;
            }
        }

        System.out.println("GOOD");
    }
}

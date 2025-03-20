import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static BigInteger factorial(int l, int r) {
        if (l > r) return BigInteger.ONE;
        if (l == r) return BigInteger.valueOf(l);
        int mid = (l + r) / 2;
        return factorial(l, mid).multiply(factorial(mid + 1, r));
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N == 0) {
            System.out.println(1);
            return;
        }
        
        System.out.println(factorial(1, N));
    }
}

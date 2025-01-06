import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(getSumOfFactors(n) * 5 - 24);
    }

    static int getSumOfFactors(int n) {
        int sum = 0;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                if (i != n / i) {
                    sum += i + (n / i);
                } else {
                    sum += i;
                }
            }
        }
        return sum;
    }

}

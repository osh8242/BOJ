import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(st.nextToken());
            int sum = 1;
            if (n == 1) sum = 0;
            else {
                int r = (int)Math.sqrt(n);
                for (int i = 2; i <= r; i++) {
                    if (n % i == 0) {
                        sum += i;
                        int j = n / i;
                        if (j != i) sum += j;
                    }
                }
            }
            if (sum == n) sb.append("Perfect\n");
            else if (sum < n) sb.append("Deficient\n");
            else sb.append("Abundant\n");
        }
        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long sum = 0;
        int c = 0;

        for (int i = 1; i <= S; i++) {
            sum += i;
            c += 1;
            if (S == 2) {
                System.out.println(1);
                break;
            }
            if (sum == S) {
                System.out.println(c);
                break;
            } else if (sum > S) {
                System.out.println(c - 1);
                break;
            }
        }
    }
}

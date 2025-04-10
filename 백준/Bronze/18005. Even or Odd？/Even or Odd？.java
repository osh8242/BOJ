import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        if (n % 2 == 1) {
            System.out.println(0);
        } else {
            int k = n / 2;
            if (k % 2 == 0) {
                System.out.println(2);
            } else {
                System.out.println(1);
            }
        }
    }
}

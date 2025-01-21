import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = Math.min(a, b); i <= n; i++) {
            if (i % a == 0 ^ i % b == 0) count++;
        }
        System.out.println(count);
    }
}

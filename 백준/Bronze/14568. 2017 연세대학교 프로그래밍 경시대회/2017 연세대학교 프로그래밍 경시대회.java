import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int t = 2; t < N; t += 2) {
            for (int y = 1; y < N; y++) {
                int sum = t + y;
                for (int x = y + 2; x < N; x++) {
                    if (sum + x == N) count++;
                }
            }
        }
        System.out.println(count);
    }
}

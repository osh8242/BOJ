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
                if(N - t - y >=  y + 2) count++;
            }
        }
        System.out.println(count);
    }
}

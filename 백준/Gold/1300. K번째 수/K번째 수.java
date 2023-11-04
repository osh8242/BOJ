import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        long low = 1;
        long high = (long) N * N;
        long answer = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;
            for (int i = 1; i <= N; i++) count += Math.min(mid / i, N);
            if (count < k) low = mid + 1;
            else {
                answer = mid;
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        double[] v = new double[N];
        for (int i = 0; i < N; i++) {
            v[i] = 1.0 / Integer.parseInt(parts[i]);
        }

        int count = 0;
        double eps = 1e-12;
        int totalMasks = 1 << N;
        for (int mask = 1; mask < totalMasks; mask++) {
            double sum = 0.0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += v[i];
                }
            }
            if (sum + eps >= 0.99 && sum - eps <= 1.01) {
                count++;
            }
        }

        System.out.print(count);
    }
}

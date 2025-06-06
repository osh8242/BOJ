import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            if (x[i] > max) max = x[i];
        }
        boolean[] present = new boolean[max + 1];
        for (int v : x) {
            present[v] = true;
        }
        int[] countDivides = new int[max + 1];
        int[] countDivisible = new int[max + 1];
        for (int d = 1; d <= max; d++) {
            if (!present[d]) continue;
            for (int m = d * 2; m <= max; m += d) {
                if (present[m]) {
                    countDivides[d]++;
                    countDivisible[m]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int val = x[i];
            int score = countDivides[val] - countDivisible[val];
            sb.append(score);
            if (i < N - 1) sb.append(' ');
        }
        System.out.print(sb.toString());
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= K; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int[] s = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
            int maxAvg = Integer.MIN_VALUE;
            int minAvg = Integer.MAX_VALUE;
            int sum = 0;
            for (int i = 0; i < w; i++) {
                sum += s[i];
            }
            int avg = sum / w;
            maxAvg = Math.max(maxAvg, avg);
            minAvg = Math.min(minAvg, avg);
            for (int i = w; i < n; i++) {
                sum += s[i] - s[i - w];
                avg = sum / w;
                if (avg > maxAvg) maxAvg = avg;
                if (avg < minAvg) minAvg = avg;
            }
            sb.append("Data Set ").append(tc).append(":\n");
            sb.append(Math.abs(maxAvg - minAvg)).append("\n\n");
        }
        System.out.print(sb);
    }
}

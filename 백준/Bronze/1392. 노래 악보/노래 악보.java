import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] scores = new int[N + 1];
        for (int i = 1; i <= N; i++) scores[i] = scores[i - 1] + Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            int q = Integer.parseInt(br.readLine());
            for (int i = 1; i <= N; i++) {
                if (scores[i] > q) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

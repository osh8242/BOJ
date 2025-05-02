import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int score = 0;
        if (N > 0) {
            int prev = Integer.parseInt(st.nextToken());
            score += prev;

            for (int i = 1; i < N; i++) {
                int curr = Integer.parseInt(st.nextToken());
                if (curr - prev != 1) {
                    score += curr;
                }
                prev = curr;
            }
        }

        System.out.println(score);
    }
}

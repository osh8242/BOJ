import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] pots = new int[N];
        Arrays.fill(pots, K);

        int day = 0;
        int waterIndex = 0;

        while (true) {
            day++;

            for (int i = 0; i < A; i++) {
                pots[waterIndex + i] += B;
            }

            for (int i = 0; i < N; i++) {
                pots[i]--;
            }

            boolean isDead = false;
            for (int pot : pots) {
                if (pot == 0) {
                    isDead = true;
                    break;
                }
            }
            
            if (isDead) {
                sb.append(day);
                break;
            }

            waterIndex = (waterIndex + A) % N;
        }

        System.out.println(sb.toString());
    }
}

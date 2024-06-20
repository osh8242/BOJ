import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] piles = new int[N];
        int sum = 0;
        
        for (int i = 0; i < N; i++) {
            piles[i] = Integer.parseInt(br.readLine());
            sum += piles[i];
        }

        int avg = sum / N;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (avg > piles[i]) {
                answer += avg - piles[i];
            }
        }

        System.out.println(answer);
    }
}

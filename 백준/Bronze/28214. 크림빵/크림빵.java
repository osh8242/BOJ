import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int sellable = 0;
        for (int bundle = 0; bundle < N; bundle++) {
            int noCreamCount = 0;
            for (int i = 0; i < K; i++) {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    noCreamCount++;
                }
            }
            if (noCreamCount < P) {
                sellable++;
            }
        }
        System.out.println(sellable);
    }
}

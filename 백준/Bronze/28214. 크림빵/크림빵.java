import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int p = 0;
            boolean flag = true;
            for (int j = 1; j <= K; j++) {
                int c = Integer.parseInt(st.nextToken());
                if (c == 0) p++;
                if (p == P) {
                    flag = false;
                    break;
                }
                if (K - j < P - p) break;
            }
            if (flag) count++;
        }
        System.out.println(count);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int cur = Integer.parseInt(br.readLine());
            int max = cur;
            for (int i = 1; i < N; i++) {
                int p = Integer.parseInt(br.readLine());
                cur = Math.max(p, cur + p);
                max = Math.max(max, cur);
            }
            sb.append(max).append('\n');
        }
        System.out.print(sb.toString());
    }
}

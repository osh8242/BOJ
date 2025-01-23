import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (A > 2 * B || A <= B) {
            System.out.println("NO");
            return;
        }

        int K = A - B;
        int C = B / K;
        int R = B % K;

        sb.append("YES").append("\n");
        sb.append(K).append("\n");

        StringBuilder burger = new StringBuilder();
        burger.append('a');
        for (int i = 0; i < C; i++) {
            burger.append("ba");
        }
        for (int i = 0; i < K - R; i++) {
            sb.append(burger).append("\n");
        }
        burger.append("ba");
        for (int i = 0; i < R; i++) {
            sb.append(burger).append("\n");
        }
        System.out.println(sb);
    }

}
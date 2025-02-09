import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean perfect = true;
            for (int j = 0; j < 10; j++) {
                int submit = Integer.parseInt(st.nextToken());
                if (submit != j % 5 + 1) {
                    perfect = false;
                    break;
                }
            }
            if (perfect) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}

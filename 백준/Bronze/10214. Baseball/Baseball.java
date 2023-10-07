import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int Y = 0;
            int K = 0;
            for (int round = 1; round <= 9; round++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Y += Integer.parseInt(st.nextToken());
                K += Integer.parseInt(st.nextToken());
            }
            String result = "";
            if (Y > K) result = "Yonsei";
            else if (Y < K) result = "Korea";
            else result = "Draw";
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}

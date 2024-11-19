import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int answer = 0;
            if (onBoundary(S, N)) {
                if (!onBoundary(E, N)) answer++;
            } else {
                answer++;
                if (!(Math.abs(S - E) == 1)) answer++;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    static boolean onBoundary(int idx, int N) {
        return idx == 1 || idx == N;
    }

}

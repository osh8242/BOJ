import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[N+1];
        for (int i = 1; i <= N; i++) {
            board[i] = Integer.parseInt(br.readLine().trim());
        }

        int pos = 1, answer = 0;
        for (int i = 1; i <= M; i++) {
            int dice = Integer.parseInt(br.readLine().trim());
            pos += dice;
            if (pos >= N) {
                answer = i;
                break;
            }
            pos += board[pos];
            if (pos >= N) {
                answer = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer);
        System.out.println(sb);
    }
}

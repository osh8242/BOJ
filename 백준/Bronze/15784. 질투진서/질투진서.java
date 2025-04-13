import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken()) - 1;
        int b = Integer.parseInt(st.nextToken()) - 1;

        int[][] X = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                X[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int jinScore = X[a][b];

        for (int j = 0; j < N; j++) {
            if (j == b) continue;
            if (X[a][j] > jinScore) {
                System.out.println("ANGRY");
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i == a) continue;
            if (X[i][b] > jinScore) {
                System.out.println("ANGRY");
                return;
            }
        }

        System.out.println("HAPPY");
    }
}

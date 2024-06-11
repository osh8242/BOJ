import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, K;
    static char[][] origin, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        origin = new char[N][N];
        for (int i = 0; i < N; i++) {
            origin[i] = br.readLine().replaceAll(" ", "").toCharArray();
        }
        result = new char[N * K][N * K];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                magnify(i, j, origin[i][j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N * K; i++) {
            for (int j = 0; j < N * K; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void magnify(int n, int m, char ch) {
        for (int i = n * K; i < (n + 1) * K; i++) {
            for (int j = m * K; j < (m + 1) * K; j++) {
                result[i][j] = ch;
            }
        }
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] A = {{1, 1}, {1, 0}};
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        long[][] answer = getPowSquare(N);
        System.out.println(answer[1][0]);
    }

    static long[][] getPowSquare(long n) {
        if (n == 1) return A;
        long[][] childMatrix = getPowSquare(n / 2);
        long[][] result = multipleMatrix(childMatrix, childMatrix);
        if (n % 2 == 1) result = multipleMatrix(result, A);
        return result;
    }

    static long[][] multipleMatrix(long[][] X, long[][] Y) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    result[i][j] += X[i][k] * Y[k][j];
                    result[i][j] %= 1000000007;
                }
            }
        }
        return result;
    }

}

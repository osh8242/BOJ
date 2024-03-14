import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] A;
    static int N;
    static long B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                A[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] answer = getPowSquare(B);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static int[][] getPowSquare(long n) {
        if (n == 1) return A;
        int[][] childMatrix = getPowSquare(n / 2);
        int[][] result = multipleMatrix(childMatrix, childMatrix);
        if (n % 2 == 1) result = multipleMatrix(result, A);
        return result;
    }

    static int[][] multipleMatrix(int[][] X, int[][] Y) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += X[i][k] * Y[k][j];
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }

}

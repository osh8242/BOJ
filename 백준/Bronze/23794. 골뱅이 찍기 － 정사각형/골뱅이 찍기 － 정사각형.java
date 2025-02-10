import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N + 2][N + 2];
        for (char[] chars : board) {
            Arrays.fill(chars, '@');
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = ' ';
            }
        }
        for (char[] chars : board) {
            sb.append(chars).append('\n');
        }
        System.out.println(sb);
    }

}

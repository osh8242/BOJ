import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int R, C, A, B;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        board = new char[R * A][C * B];

        for (int i = 0; i < R * A; i++) {
            for (int j = 0; j < C * B; j++) {
                boolean evenRow = (i / A) % 2 == 0;
                boolean evenCol = (j / B) % 2 == 0;
                board[i][j] = evenRow && evenCol ? 'X' : evenRow ? '.' : evenCol ? '.' : 'X';
            }
        }

        for (char[] chars : board) {
            sb.append(chars).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

}

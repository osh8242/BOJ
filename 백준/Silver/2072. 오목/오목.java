import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] board = new int[20][20];
        int[] dx = {0, 1, 1, -1};
        int[] dy = {1, 0, 1, 1};
        int result = -1;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int color = (i % 2 == 1) ? 1 : 2;
            board[r][c] = color;
            boolean win = false;
            for (int d = 0; d < 4; d++) {
                int count = 1;
                int nx = r + dx[d], ny = c + dy[d];
                while (nx >= 1 && nx <= 19 && ny >= 1 && ny <= 19 && board[nx][ny] == color) {
                    count++;
                    nx += dx[d];
                    ny += dy[d];
                }
                nx = r - dx[d];
                ny = c - dy[d];
                while (nx >= 1 && nx <= 19 && ny >= 1 && ny <= 19 && board[nx][ny] == color) {
                    count++;
                    nx -= dx[d];
                    ny -= dy[d];
                }
                if (count == 5) {
                    win = true;
                    break;
                }
            }
            if (win) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}

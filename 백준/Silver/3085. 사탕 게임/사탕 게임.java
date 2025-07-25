import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[][] board;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int result = 0;
        // 모든 인접한 서로 다른 색상의 쌍에 대해 교환 후 검사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 우측
                if (j + 1 < N && board[i][j] != board[i][j+1]) {
                    swap(i, j, i, j+1);
                    result = Math.max(result, maxSequence());
                    swap(i, j, i, j+1);
                }
                // 아래
                if (i + 1 < N && board[i][j] != board[i+1][j]) {
                    swap(i, j, i+1, j);
                    result = Math.max(result, maxSequence());
                    swap(i, j, i+1, j);
                }
            }
        }
        System.out.println(result);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    static int maxSequence() {
        int max = 1;
        // 행 검사
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j-1]) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }
        // 열 검사
        for (int j = 0; j < N; j++) {
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i-1][j]) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}

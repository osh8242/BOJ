import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board = new int[9][9];
    static boolean[] rowUsed = new boolean[9]; // placeholder, will use rowUsed[r*9 + num-1]
    static boolean[] colUsed = new boolean[9];
    static boolean[] boxUsed = new boolean[9];
    static boolean[][] rows = new boolean[9][10];
    static boolean[][] cols = new boolean[9][10];
    static boolean[][] boxes = new boolean[9][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int num = line.charAt(j) - '0';
                board[i][j] = num;
                if (num != 0) {
                    rows[i][num] = true;
                    cols[j][num] = true;
                    int b = (i/3)*3 + (j/3);
                    boxes[b][num] = true;
                }
            }
        }
        solve(0, 0);
    }

    static boolean solve(int r, int c) {
        if (r == 9) {
            printBoard();
            return true;
        }
        int nr = (c == 8) ? r + 1 : r;
        int nc = (c == 8) ? 0 : c + 1;
        if (board[r][c] != 0) {
            return solve(nr, nc);
        }
        int boxIndex = (r/3)*3 + (c/3);
        for (int num = 1; num <= 9; num++) {
            if (!rows[r][num] && !cols[c][num] && !boxes[boxIndex][num]) {
                board[r][c] = num;
                rows[r][num] = cols[c][num] = boxes[boxIndex][num] = true;
                if (solve(nr, nc)) return true;
                board[r][c] = 0;
                rows[r][num] = cols[c][num] = boxes[boxIndex][num] = false;
            }
        }
        return false;
    }

    static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < 9; j++) {
                line.append(board[i][j]);
            }
            sb.append(line.toString()).append('\n');
        }
        System.out.print(sb.toString());
    }
}
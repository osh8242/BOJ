import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
    }

    static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }
        if (row == 9) {
            printMap();
            System.exit(0);
        }
        if (map[row][col] != 0) {
            dfs(row, col + 1);
        } else {
            for(int value = 1; value < 10 ; value++){
                if(checkRow(row, value) && checkCol(col, value) && checkSquare(row, col, value)){
                    map[row][col] = value;
                    dfs(row, col + 1);
                    map[row][col] = 0;
                }
            }
        }
    }

    static boolean checkRow(int row, int value) {
        for (int j = 0; j < 9; j++) {
            if (map[row][j] == value) return false;
        }
        return true;
    }

    static boolean checkCol(int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[i][col] == value) return false;
        }
        return true;
    }

    static boolean checkSquare(int row, int col, int value) {
        for (int i = (row / 3) * 3; i < (row / 3) * 3 + 3; i++) {
            for (int j = (col / 3) * 3; j < (col / 3) * 3 + 3; j++) {
                if (map[i][j] == value) return false;
            }
        }
        return true;
    }

    static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : map) {
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
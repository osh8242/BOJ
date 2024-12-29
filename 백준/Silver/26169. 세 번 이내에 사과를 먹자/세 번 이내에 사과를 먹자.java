import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map = new int[7][7];
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) + 1;
        int c = Integer.parseInt(st.nextToken()) + 1;
        map[r][c] = -1;
        dfs(r, c, 0, 0);

        System.out.println(found ? 1 : 0);
    }

    static void dfs(int r, int c, int depth, int count) {
        if (found) return;
        if (count == 2) {
            found = true;
            return;
        }
        if (depth == 3) return;

        for (int i = 0; i < 4; i++) {
            int nextR = r + move[i][0];
            int nextC = c + move[i][1];
            if (inBound(nextR, nextC) && map[nextR][nextC] != -1) {
                int origin = map[nextR][nextC];
                map[nextR][nextC] = -1;
                dfs(nextR, nextC, depth + 1, origin == 1 ? count + 1 : count);
                map[nextR][nextC] = origin;
            }
        }
    }

    static boolean inBound(int r, int c) {
        return r >= 1 && r <= 5 && c >= 1 && c <= 5;
    }
}

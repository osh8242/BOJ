import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        int R = Integer.parseInt(rc[0]), C = Integer.parseInt(rc[1]);
        char[][] g = new char[R][C];
        for (int i = 0; i < R; i++) {
            g[i] = br.readLine().toCharArray();
        }
        for (int col = 0; col < C; col++) {
            int start = 0;
            for (int r = 0; r <= R; r++) {
                if (r == R || g[r][col] == '#') {
                    int len = r - start;
                    int apples = 0;
                    for (int i = start; i < r; i++) if (g[i][col] == 'a') apples++;
                    int dots = len - apples;
                    for (int i = start; i < r; i++) {
                        g[i][col] = (i - start < dots ? '.' : 'a');
                    }
                    if (r < R) g[r][col] = '#';
                    start = r + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            sb.append(g[i]).append('\n');
        }
        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int count = 0;
        boolean[][] isVisit = new boolean[R][C];
        char[][] map = new char[R][C];
        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            System.arraycopy(chars, 0, map[i], 0, C);
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isVisit[i][j] && map[i][j] == '#') {
                    count++;
                    if (j + 1 < C && map[i][j + 1] == '#') isVisit[i][j + 1] = true;
                    else if (i + 1 < R && map[i + 1][j] == '#') isVisit[i + 1][j] = true;
                }
            }
        }
        System.out.println(count);
    }
}

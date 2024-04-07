import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static final int[] dn = {1, -1, 0, 0};
    static final int[] dm = {0, 0, 1, -1};
    static int areaCount = 0;
    static int maxArea = 0;
    static int tempArea;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1) {
                    areaCount++;
                    tempArea = 0;
                    dfs(i, j);
                    maxArea = Math.max(maxArea, tempArea);
                }
            }
        }
        System.out.println(areaCount);
        System.out.println(maxArea);
    }

    static void dfs(int i, int j) {
        map[i][j] = 0;
        tempArea++;
        for(int idx = 0 ; idx < 4 ; idx++){
            int ni = i + dn[idx];
            int nj = j + dm[idx];
            if(map[ni][nj] == 1) dfs(ni,nj);
        }

    }

}

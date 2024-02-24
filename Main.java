import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static boolean[][] inSquare;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static Queue<Integer> que = new PriorityQueue<>();
    static int areaCount = 0;
    static int tempArea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        inSquare = new boolean[N + 2][M + 2];
        for(int i = 0 ; i <= M+1 ; i++) {
            inSquare[0][i] = true;
            inSquare[N+1][i] = true;
        }
        for(int i = 0 ; i <= N+1 ; i++) {
            inSquare[i][0] = true;
            inSquare[i][M+1] = true;
        }

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) + 1;
            int y1 = Integer.parseInt(st.nextToken()) + 1;
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    inSquare[x][y] = true;
                }
            }
        }
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= M; y++) {
                if (!inSquare[x][y]) {
                    areaCount++;
                    tempArea = 0;
                    dfs(x, y);
                    que.offer(tempArea);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(areaCount).append("\n");
        while (!que.isEmpty()) {
            sb.append(que.poll()).append(" ");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        tempArea++;
        inSquare[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!inSquare[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static boolean[][] isVisitable;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Horse {
        private int x;
        private int y;
        private int distance;

        public Horse(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisitable = new boolean[N + 2][M + 2];
        isVisited = new boolean[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '1') isVisitable[i][j + 1] = true;
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Horse> que = new LinkedList<>();
        isVisited[1][1] = true;
        que.add(new Horse(1, 1, 1));        
        while (!que.isEmpty()) {
            Horse horse = que.poll();
            int x = horse.x;
            int y = horse.y;
            int distance = horse.distance;
            if (x == N && y == M)
                return distance;            
            for (int i = 0; i < 4; i++) {
                if (!isVisited[x + dx[i]][y + dy[i]] && isVisitable[x + dx[i]][y + dy[i]]) {
                    isVisited[x+dx[i]][y+dy[i]] = true;
                    que.add(new Horse(x + dx[i], y + dy[i], distance + 1));
                }
            }
        }
        return -1;
    }

}
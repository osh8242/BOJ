import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] di = {1, -1, 0, 0};
    static final int[] dj = {0, 0, 1, -1};
    static int[][] map;
    static int N, M;
    static int maxSafeArea = -1;
    static List<Node> virusList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];
        for (int i = 0; i < N + 2; i++) {
            map[i][0] = 1;
            map[i][M + 1] = 1;
        }
        for (int j = 1; j < M + 1; j++) {
            map[0][j] = 1;
            map[N + 1][j] = 1;
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virusList.add(new Node(i, j));
                }
            }
        }
        start(0);
        System.out.println(maxSafeArea);
    }

    static void start(int count) {
        if (count == 3) {
            bfs();
            return;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    start(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> que = new LinkedList<>();
        for (Node node : virusList) {
            que.add(new Node(node.i, node.j));
        }

        int[][] tempMap = new int[N + 2][M + 2];
        for (int i = 0; i < N + 2; i++) tempMap[i] = map[i].clone();

        while (!que.isEmpty()) {
            Node current = que.poll();
            for (int i = 0; i < 4; i++) {
                int ni = current.i + di[i];
                int nj = current.j + dj[i];
                if (tempMap[ni][nj] == 0) {
                    tempMap[ni][nj] = 2;
                    que.offer(new Node(ni, nj));
                }
            }
        }

        countSafeArea(tempMap);
    }

    static void countSafeArea(int[][] tempMap) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (tempMap[i][j] == 0) count++;
            }
        }
        maxSafeArea = Math.max(count, maxSafeArea);
    }

    static class Node {
        private int i;
        private int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
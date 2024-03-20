import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] isAir;
    static int N, M;
    static final int[] di = {1, -1, 0, 0};
    static final int[] dj = {0, 0, 1, -1};
    static Queue<Node> cheeseQue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][M + 2];
        isAir = new boolean[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 외부공기 영역 찾기
        airInit(0, 0);

        // 처음 사라지는 치즈위치 찾아서 큐에 담기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 1 && willDisappear(i, j)) {
                    map[i][j] = 2;
                    cheeseQue.offer(new Node(i, j));
                }
            }
        }

        int time = 0; // 경과시간
        while (!cheeseQue.isEmpty()) { // 사라질 치즈가 없을 때까지 반복
            time++;
            int size = cheeseQue.size(); // 한시간 동안 사라질 치즈 개수
            while (size-- > 0) {
                Node node = cheeseQue.poll(); // 사라질 치즈 위치 불러오기
                map[node.i][node.j] = 0; // 치즈 사라짐 표시
                isAir[node.i][node.j] = true; // 외부영역으로 전환
                dfs(node.i, node.j); // 치즈가 외부영역으로 바뀌면서 생기는 추가외부영역 + 사라질 치즈 DFS 탐색
            }
        }
        System.out.println(time);
    }

    // 외부영역으로 바뀌면서 추가되는 외부영역 + 사라질 치즈 DFS 탐색
    static void dfs(int i, int j) {
        for (int idx = 0; idx < 4; idx++) {
            int ni = i + di[idx];
            int nj = j + dj[idx];
            switch (map[ni][nj]) {
                case 0 -> {
                    if (!isAir[ni][nj]) {
                        isAir[ni][nj] = true;
                        dfs(ni, nj);
                    }
                }
                case 1 -> {
                    if (willDisappear(ni, nj)) {
                        map[ni][nj] = 2;
                        cheeseQue.offer(new Node(ni, nj));
                    }
                }
            }
        }
    }

    // 사라질 치즈인지 판별
    static boolean willDisappear(int i, int j) {
        int airCount = 0;
        for (int idx = 0; idx < 4; idx++) {
            int ni = i + di[idx];
            int nj = j + dj[idx];
            if (isAir[ni][nj]) airCount++;
            if (airCount > 1) return true;
        }
        return false;
    }

    // 초기 외부영역 찾기
    static void airInit(int i, int j) {
        isAir[i][j] = true;
        for (int idx = 0; idx < 4; idx++) {
            int ni = i + di[idx];
            int nj = j + dj[idx];
            if (inBound(ni, nj) && !isAir[ni][nj] && map[ni][nj] == 0) airInit(ni, nj);
        }
    }

    // 경계 내부 판별
    static boolean inBound(int i, int j) {
        return i >= 0 && i <= N + 1 && j >= 0 && j <= M + 1;
    }

    // 위치 클래스
    static class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

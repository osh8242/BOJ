import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, K, L;
    static int[][] map;
    static Vector[] vectors = {
            new Vector(0, 1),
            new Vector(1, 0),
            new Vector(0, -1),
            new Vector(-1, 0)
    };
    static LinkedList<Vector> snake = new LinkedList<>();
    static int totalTime = 0;
    static int vectorIndex = 0;
    static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 초기 맵 초기화 및 벽 초기화
        N = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];
        for (int i = 0; i < N + 2; i++) {
            map[i][0] = 1;
            map[i][N + 1] = 1;
            map[0][i] = 1;
            map[N + 1][i] = 1;
        }
        // 사과 위치 기록
        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            map[i][j] = 2;
        }
        // 초기 위치 세팅
        snake.offer(new Vector(1, 1));
        map[1][1] = 1;
        // 이동 시작
        L = Integer.parseInt(br.readLine());
        // 주어진 방향전환이 끝날 때까지 반복
        while (L-- > 0) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            while (time > totalTime && !isEnd) {
                move();
            }
            if (direction == 'D') vectorIndex = (vectorIndex + 1) % 4;
            else vectorIndex = (vectorIndex + 3) % 4;
        }
        //
        while (!isEnd) {
            move();
        }
        System.out.println(totalTime);
    }

    // 방향에 따라 한칸 이동하는 메서드
    static void move() {
        totalTime++;
        Vector head = snake.getFirst();
        int nextX = head.x + vectors[vectorIndex].x;
        int nextY = head.y + vectors[vectorIndex].y;
        if (map[nextX][nextY] == 1) {
            isEnd = true;
            return;
        }
        if (map[nextX][nextY] != 2) {
            Vector tail = snake.getLast();
            map[tail.x][tail.y] = 0;
            snake.removeLast();
        }
        snake.addFirst(new Vector(nextX, nextY));
        map[nextX][nextY] = 1;
    }

    static class Vector {
        private int x;
        private int y;

        public Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
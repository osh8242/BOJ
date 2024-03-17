import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // map의 크기
    static int[][] map; // 입력으로 주어지는 파이프가 움직일 수 있는 공간정보
    static final int[][][] move = {
            {{0, 1}, {1, 1}, null}, // 0:가로방향일 때, 다음 이동
            {{0, 1}, {1, 1}, {1, 0}}, // 1:대각방향일 때, 다음 이동
            {null, {1, 1}, {1, 0}} // 2:세로방향일 때, 다음 이동
    };
    static int answer = 0; // 도달 조합의 수 (정답)

    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // dfs 처리
        dfs(new Pipe(0, 1, 0)); // 첫 위치와 방향으로 dfs 시작
        
        // 정답출력
        System.out.println(answer);
    }

    static void dfs(Pipe pipe) {
        if (pipe.i == N - 1 && pipe.j == N - 1) {
            answer++;
            return;
        }
        //파이프의 현재방향으로부터 이동가능한 이동배열
        int[][] pipeMove = move[pipe.direction];
        // moveIdx - 0:가로방향, 1:대각방향, 2:세로방향
        for (int moveIdx = 0; moveIdx < 3; moveIdx++) {
            if (pipeMove[moveIdx] == null) continue;
            int nextI = pipe.i + pipeMove[moveIdx][0];
            int nextJ = pipe.j + pipeMove[moveIdx][1];
            // 경계내부이면서, 다음 칸이 빈공간일 때만
            if (inBound(nextI, nextJ) && map[nextI][nextJ] == 0) {
                // 대각방향이라면, 여유공간 체크
                if (moveIdx == 1 && !checkSpace(nextI, nextJ)) continue;
                dfs(new Pipe(nextI, nextJ, moveIdx));
            }
        }
    }

    // 대각방향일 때, 이동가능 공간여부 체크
    static boolean checkSpace(int nextI, int nextJ) {
        return map[nextI - 1][nextJ] == 0 && map[nextI][nextJ - 1] == 0;
    }
    
    // 다음위치가 map 내부안인지 체크
    static boolean inBound(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    // 끝점 위치와 방향을 갖는 Pipe 객체
    static class Pipe {
        private final int i;
        private final int j;
        private final int direction;

        public Pipe(int i, int j, int direction) {
            this.i = i;
            this.j = j;
            this.direction = direction;
        }
    }

}

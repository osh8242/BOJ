import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static boolean[][] map;
    static Vector[] vectors = {
            new Vector(0, 1),
            new Vector(1, 0),
            new Vector(0, -1),
            new Vector(-1, 0),
    };

    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 맵 세팅
        map = new boolean[M + 2][N + 2];
        for (int m = 0; m <= M + 1; m++) {
            for (int n = 0; n <= N + 1; n++) {
                if (m == 0 || m == M + 1 || n == 0 || n == N + 1) map[m][n] = true;
            }
        }

        // 시작 세팅
        Vector position = new Vector(1, 1);
        map[1][1] = true;
        int tileCount = 1;
        int answer;

        // 움직임 시작
        for (int index = 0; ; index++) {
            // 모서리까지 움직임 반복
            Vector move = vectors[index % 4];
            while (!map[position.m + move.m][position.n + move.n]) {
                map[position.m + move.m][position.n + move.n] = true;
                tileCount++;
                position.m += move.m;
                position.n += move.n;
            }

            // 모든 타일을 밟았으면 종료
            if (tileCount == M * N) {
                answer = index;
                break;
            }
        }

        // 정답 출력
        System.out.println(answer);
    }


    // 위치벡터 클래스(행, 열)
    static class Vector {
        int m, n;

        public Vector(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }

}
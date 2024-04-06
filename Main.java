import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int R, C, M;
    static int[][] map;
    static Shark[] sharks;
    static int totalWeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[R + 1][C + 1];
        sharks = new Shark[M + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(i, r, c, s, d, z);
            map[r][c] = i;
            sharks[i] = shark;
        }
        for (int time = 1; time <= C; time++) {
            catchShark(time);
            for (int i = 1; i <= M; i++) {
                if (!sharks[i].isDead) moveShark(sharks[i]);
            }
        }
        System.out.println(totalWeight);

    }

    static void catchShark(int time) {
        for (int row = 1; row <= R; row++) {
            if (map[row][time] != 0) {
                Shark shark = sharks[map[row][time]];
                totalWeight += shark.z;
                shark.isDead = true;
                map[row][time] = 0;
                return;
            }
        }
    }

    static void moveShark(Shark shark) {
        if (map[shark.r][shark.c] == shark.i) {
            map[shark.r][shark.c] = 0;
        }
        int s = getEffectiveSpeed(shark.s, shark.d);
        while (s-- > 0) {
            if (!isWithinBounds(shark.r + dr[shark.d], shark.c + dc[shark.d])) {
                shark.d = changeDirection(shark.d);
            }
            shark.r += dr[shark.d];
            shark.c += dc[shark.d];
        }
        int r = shark.r;
        int c = shark.c;
        if (map[r][c] != 0) {
            Shark shark2 = sharks[map[r][c]];
            if (shark2.i < shark.i) {
                shark = getSurvivedShark(shark, shark2);
            }
        }
        map[shark.r][shark.c] = shark.i;
    }

    static Shark getSurvivedShark(Shark s1, Shark s2) {
        if (s1.z > s2.z) {
            s2.isDead = true;
            return s1;
        } else {
            s1.isDead = true;
            return s2;
        }
    }

    static int getEffectiveSpeed(int s, int d) {
        if (d == 0 || d == 1) return s % (2 * (R - 1));
        else return s % (2 * (C - 1));
    }

    static int changeDirection(int d) {
        return d % 2 == 0 ? d + 1 : d - 1;
    }

    static boolean isWithinBounds(int r, int c) {
        return r > 0 && r <= R && c > 0 && c <= C;
    }

    static class Shark {
        int i; // 상어 번호
        int r; // 상어 행 위치
        int c; // 상어 열 위치
        int s; // 상어 속도
        int d; // 상어 방향
        int z; // 상어 크기
        boolean isDead;

        public Shark(int i, int r, int c, int s, int d, int z) {
            this.i = i;
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.isDead = false;
        }
    }

}

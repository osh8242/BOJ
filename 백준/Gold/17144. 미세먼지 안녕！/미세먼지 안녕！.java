import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, T;
    static int[][] map; // 입력으로 주어진 방 분포 map
    static int[][] tempMap;
    static int totalDust = 0; // 방의 총 미세먼지
    static Integer topAP = null; // 공기청정기 위쪽 행
    static Integer bottomAP = null; // 공기청정기 아래쪽 행
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R + 2][C + 2];
        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (topAP == null) topAP = i;
                    else bottomAP = i;
                } else {
                    totalDust += map[i][j];
                }
            }
        }

        while (T-- > 0) {
            processDust();
            processCirculation(topAP, true);
            processCirculation(bottomAP, false);
        }

        System.out.println(totalDust);
    }

    static void processDust() {
        tempMap = copyMap(map);
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                switch (map[i][j]) {
                    case 0:
                    case 1:
                    case -1:
                        continue;
                    default:
                        diffuseDust(i, j);
                }
            }
        }
        map = copyMap(tempMap);
    }

    static void diffuseDust(int i, int j) {
        int diffusion = map[i][j] / 5;
        int diffCount = 0;
        for (int idx = 0; idx < 4; idx++) {
            int nextRow = i + dr[idx];
            int nextCol = j + dc[idx];
            if (!inBound(nextRow, nextCol)) continue;
            if (map[nextRow][nextCol] == -1) continue;
            diffCount++;
            tempMap[nextRow][nextCol] += diffusion;
        }
        tempMap[i][j] -= diffusion * diffCount;
    }

    static boolean inBound(int row, int col) {
        return row > 0 && row < R + 1 && col > 0 && col < C + 1;
    }

    static void processCirculation(int rowAp, boolean isTop) {
        int row = rowAp;
        int col = 2;
        int prevDust = 0;
        while (col < C) {
            prevDust = moveDust(row, col++, prevDust);
        }
        if (isTop) {
            while (row > 1) {
                prevDust = moveDust(row--, col, prevDust);
            }
        } else {
            while (row < R) {
                prevDust = moveDust(row++, col, prevDust);
            }
        }
        while (col > 1) {
            prevDust = moveDust(row, col--, prevDust);
        }
        if (isTop) {
            while (row < rowAp) {
                prevDust = moveDust(row++, col, prevDust);
            }
        } else {
            while (row > rowAp) {
                prevDust = moveDust(row--, col, prevDust);
            }
        }
        totalDust -= prevDust;

    }

    static int moveDust(int row, int col, int prevDust) {
        int tempDust = map[row][col];
        map[row][col] = prevDust;
        return tempDust;
    }

    static int[][] copyMap(int[][] map) {
        int[][] copyMap = new int[R + 2][C + 2];
        for (int i = 0; i < R + 2; i++) {
            copyMap[i] = map[i].clone();
        }
        return copyMap;
    }

}

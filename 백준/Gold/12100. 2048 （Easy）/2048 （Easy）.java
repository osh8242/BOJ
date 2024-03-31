import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int answer = 0;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sum += map[i][j];
            }
        }
        dfs(map, 0);
        System.out.println(answer);
    }

    static void dfs(int[][] currentMap, int count) {
        if (count == 5) {
            answer = Math.max(getMaxValueFromMap(currentMap), answer);
            return;
        }
        dfs(moveUp(currentMap), count + 1);
        dfs(moveDown(currentMap), count + 1);
        dfs(moveLeft(currentMap), count + 1);
        dfs(moveRight(currentMap), count + 1);
    }

    static int[][] moveUp(int[][] map) {
        int[][] result = getCopyMap(map);
        for (int j = 0; j < N; j++) {
            int writeRow = 0;
            int lastValue = 0;
            for (int i = 0; i < N; i++) {
                if (result[i][j] == 0) continue;
                if (result[i][j] == lastValue) {
                    result[writeRow - 1][j] *= 2;
                    lastValue = 0;
                    result[i][j] = 0;
                } else {
                    if (writeRow != i) result[writeRow][j] = result[i][j];
                    lastValue = result[i][j];
                    if (writeRow != i) result[i][j] = 0;
                    writeRow++;
                }
            }
        }
        return result;
    }

    static int[][] moveDown(int[][] map) {
        int[][] result = getCopyMap(map);
        for (int j = 0; j < N; j++) {
            int writeRow = N - 1;
            int lastValue = 0;
            for (int i = N - 1; i >= 0; i--) {
                if (result[i][j] == 0) continue;
                if (result[i][j] == lastValue) {
                    result[writeRow + 1][j] *= 2;
                    lastValue = 0;
                    result[i][j] = 0;
                } else {
                    if (writeRow != i) result[writeRow][j] = result[i][j];
                    lastValue = result[i][j];
                    if (writeRow != i) result[i][j] = 0;
                    writeRow--;
                }
            }
        }
        return result;
    }

    static int[][] moveLeft(int[][] map) {
        int[][] result = getCopyMap(map);
        for (int i = 0; i < N; i++) {
            int writeCol = 0;
            int lastValue = 0;
            for (int j = 0; j < N; j++) {
                if (result[i][j] == 0) continue;
                if (result[i][j] == lastValue) {
                    result[i][writeCol - 1] *= 2;
                    lastValue = 0;
                    result[i][j] = 0;
                } else {
                    if (writeCol != j) result[i][writeCol] = result[i][j];
                    lastValue = result[i][j];
                    if (writeCol != j) result[i][j] = 0;
                    writeCol++;
                }
            }
        }
        return result;
    }

    static int[][] moveRight(int[][] map) {
        int[][] result = getCopyMap(map);
        for (int i = 0; i < N; i++) {
            int writeCol = N - 1;
            int lastValue = 0;
            for (int j = N - 1; j >= 0; j--) {
                if (result[i][j] == 0) continue;
                if (result[i][j] == lastValue) {
                    result[i][writeCol + 1] *= 2;
                    lastValue = 0;
                    result[i][j] = 0;
                } else {
                    if (writeCol != j) result[i][writeCol] = result[i][j];
                    lastValue = result[i][j];
                    if (writeCol != j) result[i][j] = 0;
                    writeCol--;
                }
            }
        }
        return result;
    }

    static int[][] getCopyMap(int[][] map) {
        int[][] copyMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, N);
        }
        return copyMap;
    }

    static int getMaxValueFromMap(int[][] map) {
        int result = 0;
        for (int[] row : map) {
            for (int value : row) {
                result = Math.max(result, value);
            }
        }
        return result;
    }
}


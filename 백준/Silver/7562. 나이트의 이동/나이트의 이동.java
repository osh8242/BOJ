import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, L;
    static int[] rowOffsets = {-1, 1, -2, -2, -1, 1, 2, 2};
    static int[] colOffsets = {-2, -2, -1, 1, 2, 2, -1, 1};
    static int[][] map;
    static Position endP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            L = Integer.parseInt(br.readLine());
            map = new int[L][L];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            Position startP = new Position(startRow, startCol);
            st = new StringTokenizer(br.readLine());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());
            endP = new Position(endRow, endCol);
            int minMoveCount = getMinMoveCount(startP);
            sb.append(minMoveCount).append("\n");
        }
        System.out.println(sb);
    }

    static int getMinMoveCount(Position startP) {
        Queue<Position> que = new LinkedList<>();
        que.offer(startP);
        while (!que.isEmpty()) {
            Position currentP = que.poll();
            if (currentP.equals(endP)) return map[currentP.row][currentP.col];
            for (int i = 0; i < 8; i++) {
                int nextRow = currentP.row + rowOffsets[i];
                int nextCol = currentP.col + colOffsets[i];
                try {
                    if (map[nextRow][nextCol] == 0) {
                        map[nextRow][nextCol] = map[currentP.row][currentP.col] + 1;
                        que.offer(new Position(nextRow, nextCol));
                    }
                } catch (ArrayIndexOutOfBoundsException ignored) {
                }
            }
        }
        return 0;
    }

    static class Position {
        private final int row;
        private final int col;
        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
        public boolean equals(Position target) {
            return this.row == target.row && this.col == target.col;
        }
    }

}
import java.io.*;
import java.util.*;

public class Main {

    static Vector[] vectors;

    static {
        vectors = new Vector[9];
        vectors[1] = new Vector(1, 2);
        vectors[2] = new Vector(2, 1);
        vectors[3] = new Vector(2, -1);
        vectors[4] = new Vector(1, -2);
        vectors[5] = new Vector(-1, -2);
        vectors[6] = new Vector(-2, -1);
        vectors[7] = new Vector(-2, 1);
        vectors[8] = new Vector(-1, 2);
    }

    static boolean[][] isVisit = new boolean[9][9];
    static Vector vectorS, vectorE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        vectorS = new Vector(startX, startY);
        st = new StringTokenizer(br.readLine());
        int endX = Integer.parseInt(st.nextToken());
        int endY = Integer.parseInt(st.nextToken());
        vectorE = new Vector(endX, endY);

        int minCount = getMinimumMovesByBfs();

        bw.write(Integer.toString(minCount));
        bw.flush();
    }

    static int getMinimumMovesByBfs() {
        Queue<Vector> queue = new LinkedList<>();
        queue.add(vectorS);
        isVisit[vectorS.x][vectorS.y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Vector current = queue.poll();
                if (current.equals(vectorE)) {
                    return count;
                }
                for (int j = 1; j <= 8; j++) {
                    Vector next = current.getNextPosition(vectors[j]);
                    if (inBound(next.x, next.y) && !isVisit[next.x][next.y]) {
                        queue.add(next);
                        isVisit[next.x][next.y] = true;
                    }
                }
            }
            count++;
        }
        return -1;
    }

    static boolean inBound(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    static class Vector {
        int x;
        int y;

        public Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Vector o) {
            return x == o.x && y == o.y;
        }

        public Vector getNextPosition(Vector o) {
            return new Vector(x + o.x, y + o.y);
        }
    }
}

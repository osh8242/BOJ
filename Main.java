import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] tempMap;
    static ArrayList<Node> houses = new ArrayList<>();
    static int minChickenDistance = Integer.MAX_VALUE;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houses.add(new Node(i, j, 0));
            }
        }
        setChickenStore(1, 1, 0);
        System.out.println(minChickenDistance);
    }

    static void setChickenStore(int row, int col, int count) {
        if (count == M) {
            int chickenDistance = bfs();
            minChickenDistance = Math.min(chickenDistance, minChickenDistance);
            return;
        }
        if (row == N + 1) return;
        if (col == N + 1) {
            setChickenStore(row + 1, 1, count);
            return;
        }
        if (map[row][col] != 2) setChickenStore(row, col + 1, count);
        else {
            map[row][col] = 3;
            setChickenStore(row, col + 1, count + 1);
            map[row][col] = 2;
            setChickenStore(row, col + 1, count);
        }
    }

    static int bfs() {
        tempMap = new int[N + 2][N + 2];
        for (int i = 0; i < N + 2; i++) {
            tempMap[i] = map[i].clone();
        }
        int totalChickenDistance = 0;
        for (int index = 0; index < houses.size(); index++) {
            Node house = houses.get(index);
            Queue<Node> que = new LinkedList<>();
            que.offer(house);
            boolean[][] isVisit = new boolean[N + 2][N + 2];
            isVisit[house.row][house.col] = true;
            for (int i = 0; i <= N + 1; i++) {
                isVisit[0][i] = true;
                isVisit[i][0] = true;
                isVisit[N + 1][i] = true;
                isVisit[i][N + 1] = true;
            }
            outer:
            while (!que.isEmpty()) {
                Node node = que.poll();
                for (int i = 0; i < 4; i++) {
                    int nextRow = node.row + dr[i];
                    int nextCol = node.col + dc[i];
                    if (!isVisit[nextRow][nextCol] && tempMap[nextRow][nextCol] != 3) {
                        isVisit[nextRow][nextCol] = true;
                        que.offer(new Node(nextRow, nextCol, node.distance + 1));
                    } else if (tempMap[nextRow][nextCol] == 3) {
                        totalChickenDistance += node.distance + 1;
                        break outer;
                    }
                }
            }
        }
        return totalChickenDistance;
    }

    static class Node {
        private final int row;
        private final int col;
        private final int distance;

        public Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

}
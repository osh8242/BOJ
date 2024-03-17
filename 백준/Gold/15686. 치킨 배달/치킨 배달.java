import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Node> chicken = new ArrayList<>();
    static ArrayList<Node> house = new ArrayList<>();
    static Node[][] distance;

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
                if (map[i][j] == 1) house.add(new Node(i, j, 0));
                if (map[i][j] == 2) chicken.add(new Node(i, j, 0));
            }
        }
        distance = new Node[house.size()][chicken.size()];

        findDistances();
        for (int i = 0; i < house.size(); i++) {
            Arrays.sort(distance[i]);
        }

        setChickenStore(1, 1, 0);
        System.out.println(minChickenDistance);
    }

    static void findDistances() {
        for (int index = 0; index < house.size(); index++) {
            Node house = Main.house.get(index);
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
            int chickenIndex = 0;
            while (!que.isEmpty()) {
                Node node = que.poll();
                for (int i = 0; i < 4; i++) {
                    int nextRow = node.row + dr[i];
                    int nextCol = node.col + dc[i];
                    if (!isVisit[nextRow][nextCol]) {
                        if (map[nextRow][nextCol] != 2) {
                            isVisit[nextRow][nextCol] = true;
                            que.offer(new Node(nextRow, nextCol, node.distance + 1));
                        } else if (map[nextRow][nextCol] == 2) {
                            isVisit[nextRow][nextCol] = true;
                            distance[index][chickenIndex++] = new Node(nextRow, nextCol, node.distance + 1);
                            que.offer(new Node(nextRow, nextCol, node.distance + 1));
                        }
                    }
                }
            }
        }
    }

    static void setChickenStore(int row, int col, int count) {
        if (count == M) {
            int chickenDistance = calculateTotalDistance();
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

    static int calculateTotalDistance() {
        int totalChickenDistance = 0;
        for (int i = 0; i < distance.length; i++) {
            Node[] chicken = distance[i];
            for(int j = 0 ; j < chicken.length ; j++){
                Node node = chicken[j];
                if(map[node.row][node.col] == 3){
                    totalChickenDistance += node.distance;
                    break;
                }
            }
        }
        return totalChickenDistance;
    }

    static class Node implements Comparable<Node> {
        private final int row;
        private final int col;
        private final int distance;

        public Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }
    }

}
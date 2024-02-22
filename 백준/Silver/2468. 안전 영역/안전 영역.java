import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[][] map;
    static boolean[] heightExsist = new boolean[101];
    static boolean[][] isVisit;
    static int answer = 1;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int currentH = Integer.parseInt(st.nextToken());
                map[i][j] = currentH;
                heightExsist[currentH] = true;
            }
        }
        for (int height = 1; height <= 100; height++) {
            if (heightExsist[height]) {
                answer = Math.max(bfs(height), answer);
            }
        }
        System.out.println(answer);
    }

    static int bfs(int height) {
        int count = 0;
        isVisit = new boolean[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!isVisit[i][j] && map[i][j] > height) {
                    count++;
                    Queue<Node> que = new LinkedList<>();
                    isVisit[i][j] = true;
                    que.offer(new Node(i, j));
                    while (!que.isEmpty()) {
                        Node cNode = que.poll();
                        for(int index = 0 ; index < 4 ; index++){
                            int nRow = cNode.row + dr[index];
                            int nCol = cNode.col + dc[index];
                            if(!isVisit[nRow][nCol] && map[nRow][nCol] > height){
                                isVisit[nRow][nCol] = true;
                                que.offer(new Node(nRow, nCol));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    static class Node {
        private final int row;
        private final int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

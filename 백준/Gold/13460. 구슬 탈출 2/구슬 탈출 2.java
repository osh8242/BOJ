import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    public static int bfs(int rx, int ry, int bx, int by) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.count > 10) return -1;
            if (board[current.rx][current.ry] == 'O' && board[current.bx][current.by] != 'O') {
                return current.count;
            }

            for (int i = 0; i < 4; i++) {
                // 기울였을 때 다음 위치
                int[] nextRed = move(current.rx, current.ry, dx[i], dy[i]);
                int[] nextBlue = move(current.bx, current.by, dx[i], dy[i]);

                // 파란공이 구멍이 빠지는 경우, 건너뛰기
                if (board[nextBlue[0]][nextBlue[1]] == 'O') continue; // 파란 구슬이 구멍에 빠진 경우, 이동 무시

                // 빨간 구슬과 파란 구슬이 같은 위치에 있을 경우 위치 조정
                if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
                    int redDistance = Math.abs(nextRed[0] - current.rx) + Math.abs(nextRed[1] - current.ry);
                    int blueDistance = Math.abs(nextBlue[0] - current.bx) + Math.abs(nextBlue[1] - current.by);
                    // 이동 거리가 더 긴 구슬을 한 칸 뒤로
                    if (redDistance > blueDistance) {
                        nextRed[0] -= dx[i];
                        nextRed[1] -= dy[i];
                    } else {
                        nextBlue[0] -= dx[i];
                        nextBlue[1] -= dy[i];
                    }
                }

                // 이미 방문한 상태라면 무시
                if (visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) continue;

                // 새로운 상태를 큐에 추가
                visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
                queue.add(new Node(nextRed[0], nextRed[1], nextBlue[0], nextBlue[1], current.count + 1));
            }
        }

        // 10번 이내로 빨간 구슬을 구멍을 통해 빼낼 수 없는 경우
        return -1;
    }

    // 구슬을 이동시키는 함수
    static int[] move(int x, int y, int dx, int dy) {
        int moveCount = 0; // 이동 거리
        // 다음 이동이 벽이 아니고, 현재 위치가 구멍이 아닐 때까지 이동
        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx;
            y += dy;
            moveCount++;
        }
        return new int[] {x, y, moveCount};
    }

    static class Node {
        int rx, ry, bx, by, count;

        public Node(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

}


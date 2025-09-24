import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        char[][] a = new char[2][n];
        a[0] = br.readLine().trim().toCharArray();
        a[1] = br.readLine().trim().toCharArray();

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int max = 2 * n * 4 + 5;
        int[] qr = new int[max];
        int[] qc = new int[max];
        int[] qd = new int[max];
        int head = 0, tail = 0;
        int[][] vis = new int[2][n];

        if (n > 1 && a[0][1] != 'X') {
            vis[0][1] |= 1 << 3;
            qr[tail] = 0; qc[tail] = 1; qd[tail++] = 3;
        }
        if (a[1][0] != 'X') {
            vis[1][0] |= 1;
            qr[tail] = 1; qc[tail] = 0; qd[tail++] = 0;
        }

        boolean ok = false;
        while (head < tail && !ok) {
            int r = qr[head];
            int c = qc[head];
            int dir = qd[head++];
            char t = a[r][c];

            if (t == 'I') {
                int nd = dir ^ 2;
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                if (nr == 1 && nc == n - 1) {
                    ok = true;
                    break;
                }
                if (nr >= 0 && nr < 2 && nc >= 0 && nc < n && a[nr][nc] != 'X') {
                    int in = nd ^ 2;
                    if ((vis[nr][nc] & (1 << in)) == 0) {
                        vis[nr][nc] |= 1 << in;
                        qr[tail] = nr; qc[tail] = nc; qd[tail++] = in;
                    }
                }
            } else { // L
                if ((dir & 1) == 0) { // vertical entry -> left/right
                    for (int nd = 1; nd <= 3; nd += 2) {
                        int nr = r + dr[nd];
                        int nc = c + dc[nd];
                        if (nr == 1 && nc == n - 1) {
                            ok = true;
                            break;
                        }
                        if (nr >= 0 && nr < 2 && nc >= 0 && nc < n && a[nr][nc] != 'X') {
                            int in = nd ^ 2;
                            if ((vis[nr][nc] & (1 << in)) == 0) {
                                vis[nr][nc] |= 1 << in;
                                qr[tail] = nr; qc[tail] = nc; qd[tail++] = in;
                            }
                        }
                    }
                } else { // horizontal entry -> up/down
                    for (int nd = 0; nd <= 2; nd += 2) {
                        int nr = r + dr[nd];
                        int nc = c + dc[nd];
                        if (nr == 1 && nc == n - 1) {
                            ok = true;
                            break;
                        }
                        if (nr >= 0 && nr < 2 && nc >= 0 && nc < n && a[nr][nc] != 'X') {
                            int in = nd ^ 2;
                            if ((vis[nr][nc] & (1 << in)) == 0) {
                                vis[nr][nc] |= 1 << in;
                                qr[tail] = nr; qc[tail] = nc; qd[tail++] = in;
                            }
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(ok ? "YES" : "NO");
        System.out.print(sb.toString());
    }
}

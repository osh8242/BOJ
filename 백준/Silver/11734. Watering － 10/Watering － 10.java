import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static final int[] DR = {-1, 1, 0, 0};
    static final int[] DC = {0, 0, -1, 1};
    static int R, C;
    static int Hc, Wc;
    static int Ha, Wa;
    static char[][] A;
    static char[][] cell;
    static char[][] out;
    static boolean[][] used;

    static int arOf(int rr) {
        return rr + rr / 5;
    }

    static int acOf(int cc) {
        return cc + cc / 5;
    }

    static boolean inCell(int r, int c) {
        return 0 <= r && r < Hc && 0 <= c && c < Wc;
    }

    static char chooseLetter(int r1, int c1, int r2, int c2, int r3, int c3) {
        boolean[] bad = new boolean[26];
        int[][] xs = {{r1, c1}, {r2, c2}, {r3, c3}};
        for (int[] p : xs) {
            int r = p[0], c = p[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + DR[d], nc = c + DC[d];
                if (!inCell(nr, nc)) continue;
                if (out[nr][nc] != 0) {
                    int idx = out[nr][nc] - 'a';
                    if (0 <= idx && idx < 26) bad[idx] = true;
                }
            }
        }
        for (int i = 0; i < 26; i++) if (!bad[i]) return (char) ('a' + i);
        return 'a';
    }

    static void markFenceForHorizontal(int rr, int cc) {
        int ar = arOf(rr);
        int ac0 = acOf(cc);
        int ac1 = acOf(cc + 1);
        if (ac1 - ac0 == 2) {
            A[ar][ac0 + 1] = '_';
        }
        int ac2 = acOf(cc + 2);
        if (ac2 - ac1 == 2) {
            A[ar][ac1 + 1] = '_';
        }
    }

    static void markFenceForVertical(int rr, int cc) {
        int ac = acOf(cc);
        int ar0 = arOf(rr);
        int ar1 = arOf(rr + 1);
        if (ar1 - ar0 == 2) {
            A[ar0 + 1][ac] = '_';
        }
        int ar2 = arOf(rr + 2);
        if (ar2 - ar1 == 2) {
            A[ar1 + 1][ac] = '_';
        }
    }

    static boolean placeHorizontal(int rr, int cc) {
        if (cc + 2 >= Wc) return false;
        if (used[rr][cc] || used[rr][cc + 1] || used[rr][cc + 2]) return false;
        if (cell[rr][cc] != '.' || cell[rr][cc + 1] != '.' || cell[rr][cc + 2] != '.') return false;
        char ch = chooseLetter(rr, cc, rr, cc + 1, rr, cc + 2);
        out[rr][cc] = out[rr][cc + 1] = out[rr][cc + 2] = ch;
        used[rr][cc] = used[rr][cc + 1] = used[rr][cc + 2] = true;
        markFenceForHorizontal(rr, cc);
        return true;
    }

    static boolean placeVertical(int rr, int cc) {
        if (rr + 2 >= Hc) return false;
        if (used[rr][cc] || used[rr + 1][cc] || used[rr + 2][cc]) return false;
        if (cell[rr][cc] != '.' || cell[rr + 1][cc] != '.' || cell[rr + 2][cc] != '.') return false;
        char ch = chooseLetter(rr, cc, rr + 1, cc, rr + 2, cc);
        out[rr][cc] = out[rr + 1][cc] = out[rr + 2][cc] = ch;
        used[rr][cc] = used[rr + 1][cc] = used[rr + 2][cc] = true;
        markFenceForVertical(rr, cc);
        return true;
    }

    static void fillVerticalPass() {
        for (int c = 0; c < Wc; c++) {
            for (int r = 0; r + 2 < Hc; r++) {
                if (!used[r][c] && cell[r][c] == '.') {
                    placeVertical(r, c);
                }
            }
        }
    }

    static void fillHorizontalPass() {
        for (int r = 0; r < Hc; r++) {
            for (int c = 0; c + 2 < Wc; c++) {
                if (!used[r][c] && cell[r][c] == '.') {
                    placeHorizontal(r, c);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Hc = 5 * R;
        Wc = 5 * C;
        Ha = 6 * R - 1;
        Wa = 6 * C - 1;
        A = new char[Ha][Wa];
        for (int i = 0; i < Ha; i++) {
            String line = br.readLine();
            while (line.length() < Wa) line += " ";
            A[i] = line.toCharArray();
        }

        cell = new char[Hc][Wc];
        out = new char[Hc][Wc];
        used = new boolean[Hc][Wc];

        for (int rr = 0; rr < Hc; rr++) {
            int ar = arOf(rr);
            for (int cc = 0; cc < Wc; cc++) {
                int ac = acOf(cc);
                cell[rr][cc] = A[ar][ac];
                if (cell[rr][cc] == '#') {
                    used[rr][cc] = true;
                }
            }
        }

        fillVerticalPass();
        fillHorizontalPass();
        fillVerticalPass();
        fillHorizontalPass();

        for (int r = 0; r < Hc; r++) {
            for (int c = 0; c < Wc; c++) {
                if (cell[r][c] == '.' && !used[r][c]) {
                    if (!placeHorizontal(r, c)) {
                        placeVertical(r, c);
                    }
                }
            }
        }

        for (int rr = 0; rr < Hc; rr++) {
            int ar = arOf(rr);
            for (int cc = 0; cc < Wc; cc++) {
                int ac = acOf(cc);
                if (cell[rr][cc] == '.') {
                    char ch = out[rr][cc];
                    if (ch == 0) {
                        ch = 'a';
                    }
                    A[ar][ac] = ch;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Ha; i++) {
            sb.append(A[i]).append('\n');
        }
        System.out.print(sb);
    }
}

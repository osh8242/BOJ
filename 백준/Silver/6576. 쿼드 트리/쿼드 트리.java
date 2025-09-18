import java.io.*;
import java.util.*;
public class Main {
    static String quadTree;
    static int index;
    static int[][] bitmap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        quadTree = br.readLine().trim();
        bitmap = new int[n][n];
        index = 0;

        parseQuadTree(0, n, 0, n);

        StringBuilder sb = new StringBuilder();
        sb.append("#define quadtree_width ").append(n).append("\n");
        sb.append("#define quadtree_height ").append(n).append("\n");
        sb.append("static char quadtree_bits[] = {\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j += 8) {
                int value = 0;
                for (int k = 0; k < 8; k++) {
                    if (bitmap[i][j + k] == 1) value += (1 << k);
                }
                sb.append(String.format("0x%02x", value)).append(",");
            }
            sb.append("\n");
        }
        sb.append("};\n");

        System.out.print(sb.toString());
    }

    static void parseQuadTree(int r0, int r1, int c0, int c1) {
        char c = quadTree.charAt(index++);
        if (c == 'B') {
            for (int i = r0; i < r1; i++) {
                for (int j = c0; j < c1; j++) {
                    bitmap[i][j] = 1;
                }
            }
        } else if (c == 'W') {
            for (int i = r0; i < r1; i++) {
                for (int j = c0; j < c1; j++) {
                    bitmap[i][j] = 0;
                }
            }
        } else {
            int rm = (r0 + r1) >> 1;
            int cm = (c0 + c1) >> 1;
            parseQuadTree(r0, rm, c0, cm);
            parseQuadTree(r0, rm, cm, c1);
            parseQuadTree(rm, r1, c0, cm);
            parseQuadTree(rm, r1, cm, c1);
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] drawChar = new char[n];
        int[] drawRow = new int[n];
        int cur = 0;
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '+') {
                drawChar[i] = '/';
                drawRow[i] = cur;
                cur++;
            } else if (c == '-') {
                cur--;
                drawChar[i] = '\\';
                drawRow[i] = cur;
            } else {
                drawChar[i] = '_';
                drawRow[i] = cur;
            }
            if (drawRow[i] < minRow) minRow = drawRow[i];
            if (drawRow[i] > maxRow) maxRow = drawRow[i];
        }
        int rows = maxRow - minRow + 1;
        char[][] canvas = new char[rows][n];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < n; j++) {
                canvas[i][j] = '.';
            }
        }
        for (int i = 0; i < n; i++) {
            int r = maxRow - drawRow[i];
            canvas[r][i] = drawChar[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(canvas[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}

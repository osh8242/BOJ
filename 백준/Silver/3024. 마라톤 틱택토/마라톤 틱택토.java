import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        char[][] b = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            for (int j = 0; j < N; j++) b[i][j] = s.charAt(j);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char c = b[i][j];
                if (c == '.') continue;
                if (j + 2 < N && b[i][j+1] == c && b[i][j+2] == c) {
                    System.out.println(c);
                    return;
                }
                if (i + 2 < N && b[i+1][j] == c && b[i+2][j] == c) {
                    System.out.println(c);
                    return;
                }
                if (i + 2 < N && j + 2 < N && b[i+1][j+1] == c && b[i+2][j+2] == c) {
                    System.out.println(c);
                    return;
                }
                if (i - 2 >= 0 && j + 2 < N && b[i-1][j+1] == c && b[i-2][j+2] == c) {
                    System.out.println(c);
                    return;
                }
            }
        }
        System.out.println("ongoing");
    }
}

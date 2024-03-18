import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stars = new char[N][2 * N - 1];

        for (char[] arr : stars) {
            Arrays.fill(arr, ' ');
        }

        printStars(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (char[] arr : stars) {
            for (char c : arr) {
                sb.append(c);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void printStars(int x, int y, int N) {
        if (N == 3) {
            stars[x][y] = '*';
            stars[x + 1][y - 1] = stars[x + 1][y + 1] = '*';
            stars[x + 2][y - 2] = stars[x + 2][y - 1] = stars[x + 2][y] = stars[x + 2][y + 1] = stars[x + 2][y + 2] = '*';
            return;
        }

        int nextSize = N / 2;
        printStars(x, y, nextSize);
        printStars(x + nextSize, y - nextSize, nextSize);
        printStars(x + nextSize, y + nextSize, nextSize);
    }
}

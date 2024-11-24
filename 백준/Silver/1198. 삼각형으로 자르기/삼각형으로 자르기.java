import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Point[] points;
    static Long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        points = new Point[N];
        dp = new Long[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }

        long maxDiscriminant = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (dp[i][j] == null) dp[i][j] = calculateDiscriminant(points[i], points[j]);
                for (int k = j + 1; k < N; k++) {
                    if (dp[j][k] == null) dp[j][k] = calculateDiscriminant(points[j], points[k]);
                    if (dp[k][i] == null) dp[k][i] = calculateDiscriminant(points[k], points[i]);
                    long discriminant = Math.abs(dp[i][j] + dp[j][k] + dp[k][i]);
                    maxDiscriminant = Math.max(maxDiscriminant, discriminant);
                }
            }
        }
        System.out.println(maxDiscriminant / 2.0);
    }

    static Long calculateDiscriminant(Point a, Point b) {
        return ((long) a.x * b.y - (long) a.y * b.x);
    }

}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
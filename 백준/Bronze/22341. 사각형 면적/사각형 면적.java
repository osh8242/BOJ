import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, C;
    static int currentX, currentY;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        currentX = N;
        currentY = N;
        C = Integer.parseInt(st.nextToken());
        while (C-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x > currentX || y > currentY || x == 0 || y == 0) continue;
            if (y * currentX > x * currentY) currentY = y;
            else currentX = x;
        }
        System.out.println(currentX * currentY);

    }

}

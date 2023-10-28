import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] sides = {1000000001, -1000000001, -1000000001, 1000000001};
    static boolean[] hasBound = new boolean[4];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char side = st.nextToken().charAt(0);
            switch (side) {
                case 'L': {
                    sides[0] = Math.min(sides[0], x);
                    if (!hasBound[0]) hasBound[0] = true;
                    break;
                }
                case 'R': {
                    sides[1] = Math.max(sides[1], x);
                    if (!hasBound[1]) hasBound[1] = true;
                    break;
                }
                case 'U': {
                    sides[2] = Math.max(sides[2], y);
                    if (!hasBound[2]) hasBound[2] = true;
                    break;
                }
                case 'D': {
                    sides[3] = Math.min(sides[3], y);
                    if (!hasBound[3]) hasBound[3] = true;
                    break;
                }
            }
        }
        for (boolean b : hasBound) {
            if (!b) {
                System.out.println("Infinity");
                return;
            }
        }
        System.out.println((long) (sides[0] - sides[1] - 1) * (sides[3] - sides[2] - 1));
    }
}

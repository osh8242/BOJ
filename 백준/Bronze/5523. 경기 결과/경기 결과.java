import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        int a = 0;
        int b = 0;
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ap = Integer.parseInt(st.nextToken());
            int bp = Integer.parseInt(st.nextToken());
            if (ap == bp);
            else if (ap > bp) a++;
            else b++;
        }
        System.out.println(a + " " + b);
    }
}

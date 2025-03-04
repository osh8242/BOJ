import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[] points = {100, 100, 200, 200, 300, 300, 400, 400, 500};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int j : points) {
            int point = Integer.parseInt(st.nextToken());
            if (point > j) {
                sb.append("hacker");
                break;
            }
            sum += point;
            if (sum >= 100) {
                sb.append("draw");
                break;
            }
        }
        if (sb.length() == 0) sb.append("none");
        System.out.println(sb);
    }
}

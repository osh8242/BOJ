import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int pTime = d + n * p;
            int sTime = n * s;
            if (pTime == sTime) {
                sb.append("does not matter");
            } else if (pTime < sTime) {
                sb.append("parallelize");
            } else {
                sb.append("do not parallelize");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

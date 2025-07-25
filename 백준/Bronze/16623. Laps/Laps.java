import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int laps = 0;
        for (int i = 1; i < m; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur < prev) laps++;
            prev = cur;
        }
        System.out.println(laps);
    }
}

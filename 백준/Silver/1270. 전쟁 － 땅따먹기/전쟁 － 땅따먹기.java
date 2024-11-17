import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static final String IN_WAR = "SYJKGW";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        outer:
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int half = t / 2;
            Map<Long, Integer> map = new HashMap<>();
            for (int i = 0; i < t; i++) {
                Long n = Long.parseLong(st.nextToken());
                map.put(n, map.getOrDefault(n, 0) + 1);
                if (map.get(n) > half) {
                    sb.append(n).append("\n");
                    continue outer;
                }
            }
            sb.append(IN_WAR).append("\n");
        }
        System.out.println(sb);
    }

}

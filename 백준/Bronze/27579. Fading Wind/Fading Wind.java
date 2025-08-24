import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long h = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long v = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());
        long distance = 0;

        while (h > 0) {
            v += s;
            long dec = Math.max(1L, v / 10L);
            v -= dec;
            if (v >= k) {
                h++;
            } else if (v > 0 && v < k) {
                h--;
                if (h == 0) v = 0;
            }
            if (v <= 0) {
                h = 0;
                v = 0;
            }
            distance += v;
            if (s > 0) s--;
        }

        System.out.println(distance);
    }
}

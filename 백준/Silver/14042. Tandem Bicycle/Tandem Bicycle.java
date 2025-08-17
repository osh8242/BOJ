import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine().trim());
        int n = Integer.parseInt(br.readLine().trim());

        int[] d = new int[n];
        int[] p = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) d[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) p[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(d);
        Arrays.sort(p);

        int total = 0;
        if (q == 1) {
            for (int i = 0; i < n; i++) {
                total += Math.max(d[i], p[i]);
            }
        } else {
            for (int i = 0; i < n; i++) {
                total += Math.max(d[i], p[n - 1 - i]);
            }
        }

        System.out.println(total);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] last = new int[21];
        Arrays.fill(last, -1);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            if (last[id] == -1) {
                last[id] = pos;
            } else if (last[id] != pos) {
                ans++;
                last[id] = pos;
            }
        }
        System.out.println(ans);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Nlines = Integer.parseInt(st.nextToken());
        int[] start = new int[N+1];
        int[] total = new int[N+1];
        Arrays.fill(start, -1);
        for (int i = 0; i < Nlines; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            String kw = st.nextToken();
            int hh = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());
            int t = hh * 60 + mm;
            if (kw.equals("START")) {
                start[c] = t;
            } else {
                total[c] += (t - start[c]);
                start[c] = -1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int h = total[i] / 60;
            int m = total[i] % 60;
            sb.append(h).append(' ').append(m).append('\n');
        }
        System.out.print(sb.toString());
    }
}

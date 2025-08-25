import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        String[] a = new String[N];
        for (int i = 0; i < N; i++) a[i] = br.readLine().trim();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] cs = a[i].toCharArray();
            for (int j = 0; j < N; j++) {
                char c = cs[j];
                if (D == 1) {
                    if (c == 'd') cs[j] = 'q';
                    else if (c == 'b') cs[j] = 'p';
                    else if (c == 'q') cs[j] = 'd';
                    else if (c == 'p') cs[j] = 'b';
                } else {
                    if (c == 'd') cs[j] = 'b';
                    else if (c == 'b') cs[j] = 'd';
                    else if (c == 'q') cs[j] = 'p';
                    else if (c == 'p') cs[j] = 'q';
                }
            }
            sb.append(new String(cs)).append('\n');
        }
        System.out.print(sb.toString());
    }
}

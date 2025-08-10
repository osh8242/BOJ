import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long ans = 0;
        if (N == 1) {
            ans = 1;
        } else if (N == 2) {
            ans = Math.min(4, (M + 1) / 2);
        } else {
            if (M < 7) ans = Math.min(4, M);
            else ans = M - 2;
        }
        System.out.println(ans);
    }
}


import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double W = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        double ans;
        if (N % 2 == 0) {
            ans = H * ((N / 2.0) - 1.0);
        } else {
            long m = (N - 1) / 2;
            ans = H * (2.0 * m * m / (double) N);
        }
        System.out.printf(Locale.US, "%.6f%n", ans);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static long solve(long n) {
        long prod = 1;
        long x = n;
        for (long p = 2; p*p <= x; p++) {
            if (x % p == 0) {
                int e = 0;
                while (x % p == 0) {
                    x /= p;
                    e++;
                }
                prod *= (2L*e + 1L);
            }
        }
        if (x > 1) prod *= (2L*1 + 1L);
        return (prod + 1) / 2;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) continue;
            int slash = line.indexOf('/');
            if (slash < 0) continue;
            long n = Long.parseLong(line.substring(slash + 1));
            sb.append(solve(n)).append('\n');
        }
        System.out.print(sb.toString());
    }
}

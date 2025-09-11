import java.io.*;
import java.util.*;

public class Main {
    static boolean prevPermutation(char[] a) {
        int n = a.length;
        int i = n - 1;
        while (i > 0 && a[i - 1] <= a[i]) i--;
        if (i <= 0) return false;
        int j = n - 1;
        while (a[j] >= a[i - 1]) j--;
        char tmp = a[i - 1];
        a[i - 1] = a[j];
        a[j] = tmp;
        int l = i, r = n - 1;
        while (l < r) {
            char t = a[l];
            a[l] = a[r];
            a[r] = t;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 0; tc < T; tc++) {
            String line;
            while ((line = br.readLine()) != null && line.trim().isEmpty()) {}
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            sb.append("The bit patterns are\n");

            char[] a = new char[n];
            for (int i = 0; i < k; i++) a[i] = '1';
            for (int i = k; i < n; i++) a[i] = '0';

            sb.append(a).append('\n');
            while (prevPermutation(a)) {
                sb.append(a).append('\n');
            }
            if (tc != T - 1) sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}

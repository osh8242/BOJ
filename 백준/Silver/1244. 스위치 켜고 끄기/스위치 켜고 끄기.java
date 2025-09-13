import java.io.*;
import java.util.*;

public class Main {
    static void toggle(int[] a, int idx) {
        a[idx] = a[idx] ^ 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                for (int i = num; i <= n; i += num) toggle(arr, i);
            } else {
                toggle(arr, num);
                int l = num - 1, r = num + 1;
                while (l >= 1 && r <= n && arr[l] == arr[r]) {
                    toggle(arr, l);
                    toggle(arr, r);
                    l--;
                    r++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]);
            if (i < n) sb.append(' ');
            if (i % 20 == 0) sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}

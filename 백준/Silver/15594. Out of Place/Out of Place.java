import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(br.readLine().trim());
        int[] b = a.clone();
        Arrays.sort(b);
        int mismatch = 0;
        for (int i = 0; i < N; i++) if (a[i] != b[i]) mismatch++;
        if (mismatch == 0) System.out.println(0);
        else System.out.println(mismatch - 1);
    }
}

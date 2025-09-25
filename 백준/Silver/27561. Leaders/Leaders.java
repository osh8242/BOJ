import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        int[] E = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) E[i] = Integer.parseInt(st.nextToken());

        int firstG = 0, lastG = 0, firstH = 0, lastH = 0;
        for (int i = 1; i <= N; i++) {
            char c = s.charAt(i - 1);
            if (c == 'G') {
                if (firstG == 0) firstG = i;
                lastG = i;
            } else {
                if (firstH == 0) firstH = i;
                lastH = i;
            }
        }

        int[] diffH = new int[N + 3];
        int[] diffG = new int[N + 3];
        for (int i = 1; i <= N; i++) {
            if (s.charAt(i - 1) == 'H') {
                diffH[i]++;
                diffH[E[i] + 1]--;
            } else {
                diffG[i]++;
                diffG[E[i] + 1]--;
            }
        }
        int[] coverH = new int[N + 2];
        int[] coverG = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            coverH[i] = coverH[i - 1] + diffH[i];
            coverG[i] = coverG[i - 1] + diffG[i];
        }

        boolean gAll = firstG != 0 && E[firstG] >= lastG;
        boolean hAll = firstH != 0 && E[firstH] >= lastH;

        boolean hCoversG = false, gCoversH = false;
        if (hAll) hCoversG = firstH <= firstG && firstG <= E[firstH];
        if (gAll) gCoversH = firstG <= firstH && firstH <= E[firstG];

        long res = 0;
        if (gAll) {
            res += coverH[firstG];
            if (hCoversG) res -= 1;
        }
        if (hAll) {
            res += coverG[firstH];
            if (gCoversH) res -= 1;
        }
        if (gAll && hAll) res += 1;

        StringBuilder sb = new StringBuilder();
        sb.append(res).append('\n');
        System.out.print(sb.toString());
    }
}

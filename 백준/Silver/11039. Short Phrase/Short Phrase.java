import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            line = line.trim();
            if (line.length() == 0) continue;
            int n = Integer.parseInt(line);
            if (n == 0) break;
            String[] words = new String[n];
            int[] len = new int[n];
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine().trim();
                len[i] = words[i].length();
            }
            int[] targets = {5,7,5,7,7};
            int answer = -1;
            outer:
            for (int s = 0; s < n; s++) {
                int idx = s;
                for (int t = 0; t < targets.length; t++) {
                    int need = targets[t];
                    int sum = 0;
                    while (idx < n && sum < need) {
                        sum += len[idx];
                        idx++;
                    }
                    if (sum != need) continue outer;
                }
                answer = s + 1;
                break;
            }
            out.append(answer).append('\n');
        }
        System.out.print(out);
    }
}
    
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] genes = new String[n];
        int idx = 0;
        while (idx < n) {
            String line = br.readLine();
            if (line == null) break;
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens() && idx < n) genes[idx++] = st.nextToken();
        }
        int[] countFirst = new int[26];
        int[] countSecond = new int[26];
        int[][] pair = new int[26][26];
        for (int i = 0; i < n; i++) {
            String s = genes[i];
            int a = s.charAt(0) - 'A';
            int b = s.charAt(1) - 'A';
            countFirst[a]++;
            countSecond[b]++;
            pair[a][b]++;
        }
        boolean[] possible = new boolean[26];
        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                if (countFirst[a] > 0 && countSecond[b] > 0) {
                    if (countFirst[a] == 1 && countSecond[b] == 1 && pair[a][b] == 1) continue;
                    int c = Math.max(a, b);
                    possible[c] = true;
                }
            }
        }
        ArrayList<Character> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) if (possible[i]) res.add((char)('A' + i));
        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
            if (i < res.size() - 1) System.out.print(' ');
        }
        System.out.println();
    }
}

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line == null) return;
            line = line.trim();
            if (line.length() == 0) continue;
            int n = Integer.parseInt(line);
            if (n == 0) return;
            String[] a = new String[n];
            for (int i = 0; i < n; i++) a[i] = br.readLine();
            int col = 1;
            String first = a[0];
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != ' ') { col = i + 1; break; }
            }
            for (int i = 0; i < n; i++) {
                while (true) {
                    int idx = col - 1;
                    if (idx >= a[i].length()) break;
                    if (a[i].charAt(idx) == ' ') break;
                    col++;
                }
            }
            System.out.println(col);
        }
    }
}

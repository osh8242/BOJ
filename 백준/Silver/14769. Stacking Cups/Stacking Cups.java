import java.io.*;
import java.util.*;

public class Main {
    static class Cup {
        int r;
        String color;
        Cup(int r, String color) { this.r = r; this.color = color; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Cup> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            String a = st.nextToken();
            String b = st.nextToken();
            if (Character.isDigit(a.charAt(0))) {
                int r = Integer.parseInt(a) / 2;
                list.add(new Cup(r, b));
            } else {
                int r = Integer.parseInt(b);
                list.add(new Cup(r, a));
            }
        }
        Collections.sort(list, new Comparator<Cup>() {
            public int compare(Cup c1, Cup c2) { return Integer.compare(c1.r, c2.r); }
        });
        StringBuilder sb = new StringBuilder();
        for (Cup c : list) sb.append(c.color).append('\n');
        System.out.print(sb.toString());
    }
}

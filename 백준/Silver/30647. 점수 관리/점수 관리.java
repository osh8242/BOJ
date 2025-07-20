import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class P {
        String name;
        int score;
        int isHidden;
        int rank;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringBuilder sbAll = new StringBuilder();
        for (int i = 0; i < N + 2; i++) {
            sbAll.append(br.readLine());
        }
        String all = sbAll.toString();
        List<P> list = new ArrayList<>();
        int idx = 0;
        while (true) {
            int start = all.indexOf('{', idx);
            if (start == -1) break;
            int end = all.indexOf('}', start);
            String obj = all.substring(start + 1, end);
            P p = new P();
            int ni = obj.indexOf("\"name\":\"") + 8;
            int nj = obj.indexOf('"', ni);
            p.name = obj.substring(ni, nj);
            int si = obj.indexOf("\"score\":", nj) + 8;
            int sj = obj.indexOf(',', si);
            p.score = Integer.parseInt(obj.substring(si, sj));
            int hi = obj.indexOf("\"isHidden\":", sj) + 11;
            p.isHidden = Integer.parseInt(obj.substring(hi).trim());
            list.add(p);
            idx = end + 1;
        }
        list.sort((a, b) -> {
            if (b.score != a.score) return b.score - a.score;
            return a.name.compareTo(b.name);
        });
        int rank = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i).score != list.get(i-1).score) {
                rank = i + 1;
            }
            list.get(i).rank = rank;
        }
        StringBuilder out = new StringBuilder();
        for (P p : list) {
            if (p.isHidden == 0) {
                out.append(p.rank).append(' ')
                   .append(p.name).append(' ')
                   .append(p.score).append('\n');
            }
        }
        System.out.print(out);
    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> ans = new ArrayList<>();
        int pos = 1;
        for (int num = 0; ans.size() < 5; num++) {
            String b = Integer.toBinaryString(num);
            for (int i = 0; i < b.length() && ans.size() < 5; i++) {
                if (pos % n == k % n) ans.add(b.charAt(i) - '0');
                pos++;
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            out.append(ans.get(i));
            if (i < ans.size() - 1) out.append(' ');
        }
        bw.write(out.toString());
        bw.flush();
    }
}

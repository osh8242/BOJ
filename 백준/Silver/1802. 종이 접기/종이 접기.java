import java.io.*;
public class Main {
    static boolean valid(String s) {
        int n = s.length();
        if (n == 1) return true;
        int mid = n / 2;
        String left = s.substring(0, mid);
        String right = s.substring(mid + 1);
        int L = left.length();
        for (int i = 0; i < L; i++) {
            char a = left.charAt(L - 1 - i);
            char expected = (a == '0') ? '1' : '0';
            if (right.charAt(i) != expected) return false;
        }
        return valid(left);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            String s = br.readLine().trim();
            sb.append(valid(s) ? "YES" : "NO").append('\n');
        }
        System.out.print(sb.toString());
    }
}

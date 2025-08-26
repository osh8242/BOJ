import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        if (s.length() == 0) {
            System.out.println(0);
            return;
        }
        int cnt0 = 0, cnt1 = 0;
        char prev = s.charAt(0);
        if (prev == '0') cnt0++; else cnt1++;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != prev) {
                if (c == '0') cnt0++; else cnt1++;
                prev = c;
            }
        }
        System.out.println(Math.min(cnt0, cnt1));
    }
}


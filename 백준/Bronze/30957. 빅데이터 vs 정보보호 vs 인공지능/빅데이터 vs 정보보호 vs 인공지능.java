import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int half = N / 2;
        int s = 0;
        int b = 0;
        int a = 0;
        int max = 0;
        String memo = br.readLine();
        for (char c : memo.toCharArray()) {
            if (c == 'S') {
                s++;
                max = Math.max(max, s);
            } else if (c == 'B') {
                b++;
                max = Math.max(max, b);
            } else if (c == 'A') {
                a++;
                max = Math.max(max, a);
            }
            if (max > half) break;
        }
        StringBuilder sb = new StringBuilder();
        if (b == s && s == a) sb.append("SCU");
        else {
            if (max == b) sb.append("B");
            if (max == s) sb.append("S");
            if (max == a) sb.append("A");
        }
        System.out.println(sb);
    }

}

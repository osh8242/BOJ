import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("")) continue;
            int n = Integer.parseInt(line);
            if (n == 0) break;
            BigInteger fact = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            int[] cnt = new int[10];
            String s = fact.toString();
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - '0']++;
            }
            sb.append(n).append("! --\n");
            for (int i = 0; i < 5; i++) {
                append(sb, cnt, i);
            }
            sb.append("\n");
            for (int i = 5; i < 10; i++) {
                append(sb, cnt, i);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void append(StringBuilder sb, int[] cnt, int i) {
        if (i % 5 != 0) sb.append(" ");
        sb.append("   (").append(i).append(")");
        String countStr = Integer.toString(cnt[i]);
        int pad = 5 - countStr.length();
        for (int j = 0; j < pad; j++) {
            sb.append(" ");
        }
        sb.append(countStr);
    }
}

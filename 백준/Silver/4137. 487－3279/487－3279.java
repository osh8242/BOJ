import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        TreeMap<String, Integer> cnt = new TreeMap<>();
        char[] map = new char[256];
        for (char c: "ABC".toCharArray()) map[c] = '2';
        for (char c: "DEF".toCharArray()) map[c] = '3';
        for (char c: "GHI".toCharArray()) map[c] = '4';
        for (char c: "JKL".toCharArray()) map[c] = '5';
        for (char c: "MNO".toCharArray()) map[c] = '6';
        for (char c: "PRS".toCharArray()) map[c] = '7';
        for (char c: "TUV".toCharArray()) map[c] = '8';
        for (char c: "WXY".toCharArray()) map[c] = '9';

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringBuilder sb = new StringBuilder(7);
            for (int j = 0; j < line.length() && sb.length() < 7; j++) {
                char c = line.charAt(j);
                if (c == '-') continue;
                if (c >= '0' && c <= '9') sb.append(c);
                else sb.append(map[c]);
            }
            sb.insert(3, '-');
            String std = sb.toString();
            cnt.put(std, cnt.getOrDefault(std, 0) + 1);
        }

        StringBuilder out = new StringBuilder();
        for (Map.Entry<String,Integer> e : cnt.entrySet()) {
            if (e.getValue() > 1) {
                out.append(e.getKey())
                   .append(' ')
                   .append(e.getValue())
                   .append('\n');
            }
        }
        if (out.length() == 0) {
            System.out.print("No duplicates.\n");
        } else {
            System.out.print(out);
        }
    }
}

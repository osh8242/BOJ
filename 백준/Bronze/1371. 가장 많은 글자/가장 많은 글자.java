import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        char[] chars = new char[26];
        String line = "";
        int maxCount = Integer.MIN_VALUE;
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch != ' ') {
                    maxCount = maxCount < ++chars[ch - 97] ? chars[ch - 97] : maxCount;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == maxCount) sb.append((char) (i + 97));
        }
        System.out.println(sb);

    }

}

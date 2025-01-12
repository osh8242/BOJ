import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while (!"#".equals(input = br.readLine().toLowerCase())) {
            int count = 0;
            boolean[] chars = new boolean[26];
            for (char c : input.toCharArray()) {
                if (c >= 'a' && c <= 'z' && !chars[c - 'a']) {
                    chars[c - 'a'] = true;
                    count++;
                }
                if (count == 26) break;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

}

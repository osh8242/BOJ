import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        if (input.length() < 26) {
            boolean[] used = new boolean[26];
            for (char ch : input.toCharArray()) {
                used[ch - 'a'] = true;
            }
            for (int i = 0; i < used.length; i++) {
                if (!used[i]) {
                    System.out.println(input + (char) (i + 'a'));
                    return;
                }
            }
        } else {
            boolean[] suffix = new boolean[26];
            for (int i = 25; i >= 0; i--) {
                char ch = input.charAt(i);
                for (int j = ch - 'a'; j < 26; j++) {
                    if (suffix[j]) {
                        System.out.println(input.substring(0, i) + (char) (j + 'a'));
                        return;
                    }
                }
                suffix[ch - 'a'] = true;
            }
        }

        System.out.println(-1);
    }
}

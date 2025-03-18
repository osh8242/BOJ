import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String line = br.readLine().toLowerCase();
            boolean[] alphabet = new boolean[26];
            int count = 26;
            for (char c : line.toCharArray()) {
                if (isAlphabet(c) && !alphabet[c - 'a']) {
                    alphabet[c - 'a'] = true;
                    count--;
                }
            }

            if (count == 0) sb.append("pangram");
            else appendMissingAlphabet(sb, alphabet);

            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void appendMissingAlphabet(StringBuilder sb, boolean[] alphabet) {
        sb.append("missing ");
        for (int i = 0; i < alphabet.length; i++) {
            if (!alphabet[i]) {
                sb.append((char) (i + 'a'));
            }
        }
    }

    static boolean isAlphabet(char c) {
        return c >= 'a' && c <= 'z';
    }
}

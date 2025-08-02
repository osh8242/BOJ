import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        while (n-- > 0) {
            String s = br.readLine();
            boolean[] present = new boolean[26];
            for (char c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    present[Character.toUpperCase(c) - 'A'] = true;
                }
            }
            boolean ok = true;
            for (int i = 0; i < 26; i++) {
                if (present[i]) {
                    int opp = 25 - i;
                    if (!present[opp]) {
                        ok = false;
                        break;
                    }
                }
            }
            System.out.println(ok ? "Yes" : "No");
        }
    }
}

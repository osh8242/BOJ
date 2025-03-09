import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String line = br.readLine();
            int[] freq = new int[26];
            for (char c : line.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    freq[c - 'a']++;
                }
            }
            int max = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > max) {
                    max = freq[i];
                }
            }
            ArrayList<Character> maxChars = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (freq[i] == max && max > 0) {
                    maxChars.add((char) (i + 'a'));
                }
            }
            if (maxChars.size() == 1) {
                System.out.println(maxChars.get(0));
            } else {
                System.out.println("?");
            }
        }
    }
}

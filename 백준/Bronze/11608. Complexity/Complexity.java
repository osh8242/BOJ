import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int maxKeep = 0;
        // 하나 문자만 남길 때
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxKeep) maxKeep = freq[i];
        }
        // 두 문자 남길 때
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            for (int j = i + 1; j < 26; j++) {
                if (freq[j] == 0) continue;
                int sum = freq[i] + freq[j];
                if (sum > maxKeep) maxKeep = sum;
            }
        }
        System.out.println(n - maxKeep);
    }
}

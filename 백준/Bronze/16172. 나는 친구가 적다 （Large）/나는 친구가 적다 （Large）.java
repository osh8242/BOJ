import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0, i = 1;
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }

    public static boolean kmpSearch(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        int[] lps = buildLPS(pat);
        int i = 0, j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++; j++;
                if (j == m) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String K = br.readLine();
        StringBuilder filtered = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) filtered.append(c);
        }
        boolean found = kmpSearch(filtered.toString(), K);
        System.out.println(found ? 1 : 0);
    }
}

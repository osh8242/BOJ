import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int[] cnt = new int[26];
        for (int i = 0; i < A.length(); i++) {
            cnt[A.charAt(i) - 'A']++;
            cnt[B.charAt(i) - 'A']--;
        }
        for (int v : cnt) {
            if (v != 0) {
                System.out.print(-1);
                return;
            }
        }

        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int i = a.length - 1;
        int j = i;
        int move = 0;

        while (i >= 0) {
            while (j >= 0 && a[j] != b[i]) {
                j--;
                move++;
            }
            if (j < 0) break;
            i--;
            j--;
        }

        System.out.print(move);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int L = S.length();
        String[] suffixes = new String[L];
        for (int i = 0; i < L; i++) {
            suffixes[i] = S.substring(i);
        }
        Arrays.sort(suffixes);
        StringBuilder sb = new StringBuilder();
        for (String suf : suffixes) {
            sb.append(suf).append('\n');
        }
        System.out.print(sb);
    }
}

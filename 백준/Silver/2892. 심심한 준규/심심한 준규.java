import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(st.nextToken(), 16);
            char out = '?';
            for (int k = 48; k <= 57; k++) {
                int p = c ^ k;
                if (p == 46 || p == 32) {
                    out = '.';
                    break;
                }
                if (p >= 97 && p <= 122) {
                    out = '-';
                    break;
                }
            }
            sb.append(out);
        }
        System.out.println(sb.toString());
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String s = br.readLine().trim();
            int sum = 0;
            int pos = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                int d = s.charAt(i) - '0';
                if (pos % 2 == 0) {
                    d *= 2;
                    if (d > 9) d -= 9;
                }
                sum += d;
                pos++;
            }
            sb.append((sum % 10 == 0) ? 'T' : 'F').append('\n');
        }
        System.out.print(sb);
    }
}

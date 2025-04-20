import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        for (int missing = 1; missing <= n; missing++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (i == missing) continue;
                sb.append(i);
            }
            if (sb.toString().equals(s)) {
                System.out.println(missing);
                break;
            }
        }
    }
}

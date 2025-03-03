import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String I = br.readLine();
            String P = br.readLine();
            sb.append("Case #").append(tc).append(": ");

            if (P.length() < I.length()) {
                sb.append("IMPOSSIBLE\n");
                continue;
            }

            int i = 0, p = 0, count = 0;
            boolean isPossible = true;

            while (i < I.length() && p < P.length()) {
                if (I.charAt(i) == P.charAt(p)) {
                    i++;
                    p++;
                } else {
                    count++;
                    p++;
                }

                if (I.length() - i > P.length() - p) {
                    isPossible = false;
                    break;
                }
            }

            if (i != I.length()) isPossible = false;
            else count += P.length() - p;

            sb.append(isPossible ? count : "IMPOSSIBLE").append("\n");
        }
        System.out.println(sb);
    }
}

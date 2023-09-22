import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(" ".repeat(Math.max(0, n - i)))
                    .append("*");
            if (i == 1) sb.append("\n");
            else sb.append(" ".repeat(Math.max(0, 2 * (i - 2) + 1)))
                    .append("*")
                    .append("\n");

        }
        System.out.println(sb);
    }
}

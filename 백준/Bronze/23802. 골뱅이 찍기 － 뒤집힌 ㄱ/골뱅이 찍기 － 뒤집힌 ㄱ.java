import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String AT = "@@@@@";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            sb.append(AT.repeat(n));
            sb.append("\n");
        }
        sb.append(("@".repeat(n) + "\n").repeat(4).repeat(n));
        System.out.println(sb);
    }
}

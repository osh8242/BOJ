import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("int a;").append("\n");
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            appendNthString(sb, i);
        }
        System.out.println(sb);
    }

    static void appendNthString(StringBuilder sb, int n) {
        sb.append("int ");
        for (int i = 0; i < n; i++) sb.append("*");
        sb.append("ptr");
        if (n != 1) sb.append(n);
        sb.append(" = &");
        sb.append(n == 1 ? "a" : "ptr");
        if (n > 2) sb.append(n - 1);
        sb.append(";").append("\n");
    }

}

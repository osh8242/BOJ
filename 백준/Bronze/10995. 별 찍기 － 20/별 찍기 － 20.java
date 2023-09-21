import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(i%2 == 0) sb.append(" ");
            for (int j = 1; j <= n; j++) {
                if (j == n) sb.append("*").append("\n");
                else sb.append("* ");
            }
        }
        System.out.println(sb);
    }
}

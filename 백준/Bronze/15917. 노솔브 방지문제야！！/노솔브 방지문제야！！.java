import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            int a = Integer.parseInt(br.readLine());
            while (a > 1) {
                if (a % 2 == 0) a /= 2;
                else break;
            }
            sb.append(a == 1 ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}

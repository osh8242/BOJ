import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String input;

        while (!(input = br.readLine()).equals("0")) {
            int n = Integer.parseInt(input);
            sb.append(n * (n + 1) * (2 * n + 1) / 6).append("\n");
        }

        System.out.println(sb);
    }

}

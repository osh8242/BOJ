import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            result.append("Case #")
                .append(i).append(": ")
                .append(a).append(" + ")
                .append(b).append(" = ")
                .append(a + b)
                .append('\n');
        }
        System.out.println(result);
    }
}

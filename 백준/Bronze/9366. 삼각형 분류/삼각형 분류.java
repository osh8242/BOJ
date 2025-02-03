import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static String classifyTriangle(int a, int b, int c) {
        if (a == b && b == c) {
            return "equilateral";
        }
        int max = Math.max(a, Math.max(b, c));
        int sum = a + b + c;
        if (sum <= 2 * max) {
            return "invalid!";
        }
        if (a == b || b == c || a == c) {
            return "isosceles";
        }
        return "scalene";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            String result = classifyTriangle(a, b, c);
            sb.append("Case #").append(i).append(": ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        int index = 1;
        while (true) {
            input = br.readLine();
            if (input.equals("0 0 0")) break;
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            boolean isNormal = false;
            if (c == -1) isNormal = true;
            else if (a == -1 && (b < c)) isNormal = true;
            else if (b == -1 && (a < c)) isNormal = true;

            sb.append("Triangle #").append(index++).append("\n");
            if (isNormal) {
                if (a == -1) {
                    double result = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));
                    sb.append("a = ").append(String.format("%.3f", result)).append("\n");
                } else if (b == -1) {
                    double result = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
                    sb.append("b = ").append(String.format("%.3f", result)).append("\n");
                } else {
                    double result = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                    sb.append("c = ").append(String.format("%.3f", result)).append("\n");
                }
            } else {
                sb.append("Impossible.\n");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}

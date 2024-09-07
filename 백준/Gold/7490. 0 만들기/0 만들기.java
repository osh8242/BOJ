import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static List<String> results;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            results = new ArrayList<>();

            dfs(1, "1");

            Collections.sort(results);
            for (String result : results) {
                bw.write(result + "\n");
            }

            if (t < T - 1) {
                bw.write("\n");
            }
        }

        bw.flush();
    }

    static void dfs(int num, String expression) {
        if (num == N) {
            if (calculate(expression) == 0) {
                results.add(expression);
            }
            return;
        }

        dfs(num + 1, expression + "+" + (num + 1));
        dfs(num + 1, expression + "-" + (num + 1));
        dfs(num + 1, expression + " " + (num + 1));
    }

    static int calculate(String expression) {
        expression = expression.replace(" ", "");
        int sum = 0;
        int num = 0;
        char sign = '+';

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if (!Character.isDigit(ch) || i == expression.length() - 1) {
                if (sign == '+') {
                    sum += num;
                } else if (sign == '-') {
                    sum -= num;
                }
                sign = ch;
                num = 0;
            }
        }

        return sum;
    }
}

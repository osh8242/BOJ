import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] elements = br.readLine().split(" ");
            long a = Long.parseLong(elements[0]);
            long b = Long.parseLong(elements[2]);
            long c = Long.parseLong(elements[4]);
            sb.append(calculate(a, elements[1], b) == c ? "correct" : "wrong answer").append("\n");
        }
        System.out.println(sb);
    }

    static long calculate(long a, String op, long b) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}

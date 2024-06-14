import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] tokens = new String[2 * N - 1];
        for (int i = 0; i < 2 * N - 1; i++) {
            tokens[i] = br.readLine();
        }

        BigInteger result = evaluateExpression(tokens);
        System.out.println(result);
    }

    private static BigInteger evaluateExpression(String[] tokens) {
        Deque<BigInteger> values = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                while (!operators.isEmpty() && hasPrecedence(token, operators.peek())) {
                    BigInteger b = values.pop();
                    BigInteger a = values.pop();
                    String op = operators.pop();
                    values.push(applyOperation(a, b, op));
                }
                operators.push(token);
            } else {
                values.push(new BigInteger(token));
            }
        }

        while (!operators.isEmpty()) {
            BigInteger b = values.pop();
            BigInteger a = values.pop();
            String op = operators.pop();
            values.push(applyOperation(a, b, op));
        }

        return values.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private static boolean hasPrecedence(String op1, String op2) {
        if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"))) {
            return false;
        }
        return true;
    }

    private static BigInteger applyOperation(BigInteger a, BigInteger b, String op) {
        switch (op) {
            case "+":
                return a.add(b);
            case "-":
                return a.subtract(b);
            case "*":
                return a.multiply(b);
            case "/":
                return divideAndFloor(a, b);
            default:
                throw new UnsupportedOperationException("Unknown operator: " + op);
        }
    }

    private static BigInteger divideAndFloor(BigInteger a, BigInteger b) {
        BigDecimal dividend = new BigDecimal(a);
        BigDecimal divisor = new BigDecimal(b);
        BigDecimal quotient = dividend.divide(divisor, 0, RoundingMode.FLOOR);
        return quotient.toBigInteger();
    }
}

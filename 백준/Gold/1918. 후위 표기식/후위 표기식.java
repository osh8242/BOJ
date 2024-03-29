import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (char ch : br.readLine().toCharArray()) {
            switch (ch) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && getPriority(ch) <= getPriority(stack.peek())) {
                        sb.append(stack.pop());
                    }
                    stack.add(ch);
                    break;
                case '(':
                    stack.add(ch);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(ch);
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);

    }

    static int getPriority(char ch) {
        return switch (ch) {
            case '(', ')' -> 0;
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 1) {
            System.out.println(-1);
            return;
        }
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int depth = 0;

        for (char c : str.toCharArray()) {
            if (!stack.isEmpty()
                    && (stack.peek() == '(' && c == ')'
                    || stack.peek() == ')' && c == '(')) stack.pop();
            else stack.push(c);

            depth = Math.max(depth, stack.size());
        }

        if (!stack.isEmpty()) {
            depth = -1;
        }

        System.out.println(depth);
    }
}

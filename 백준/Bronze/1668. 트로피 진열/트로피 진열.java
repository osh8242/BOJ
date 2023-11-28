import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> heights = new ArrayDeque<>();
        for (int i = 0; i < N; i++) heights.addLast(Integer.parseInt(br.readLine()));
        int left = getCount(heights, N, true);
        int right = getCount(heights, N, false);
        ;
        System.out.println(left + "\n" + right);
    }

    static int getCount(Deque<Integer> deque, int N, boolean isLeft) {
        Stack<Integer> stack = new Stack<>();
        int firstHeight = isLeft ? deque.pollFirst() : deque.pollLast();
        stack.push(firstHeight);
        if (isLeft) deque.addLast(firstHeight);
        while (N-- > 1) {
            int height = isLeft ? deque.pollFirst() : deque.pollLast();
            if (isLeft) deque.addLast(height);
            if (height > stack.peek()) stack.push(height);
        }
        return stack.size();
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] nums;
    static Stack<Integer> stack = new Stack<>();
    static int[] answer;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        answer = new int[N];
        for (int i = 0; i < N; i++) answer[i] = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        findRightBigNumber();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);

    }

    static void findRightBigNumber() {
        stack.push(0);
        for (int i = 1; i < N; i++) {
            int newNum = nums[i];
            int index = stack.peek();
            while (nums[index] < newNum && !stack.isEmpty()) {
                answer[index] = newNum;
                stack.pop();
                if (!stack.isEmpty()) index = stack.peek();
            }
            stack.push(i);
        }
    }
}

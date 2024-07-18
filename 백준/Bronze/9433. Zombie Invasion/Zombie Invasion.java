import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Stack<Integer> stack = new Stack<>();
            Stack<Integer> result = new Stack<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                stack.push(Integer.parseInt(st.nextToken()));
            }

            int move = 0;
            while (!stack.isEmpty()) {
                int current = stack.pop() + move;
                if (!stack.isEmpty()) {
                    result.push(current % 2 == 0 ? 0 : 1);
                    move = current / 2;
                } else result.push(current);
            }

            while (!result.isEmpty()) {
                sb.append(result.pop()).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}

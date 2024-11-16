import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, J;
    static int left = 1;
    static int right;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        right = left + Integer.parseInt(st.nextToken()) - 1;
        J = Integer.parseInt(br.readLine());
        while (J-- > 0) {
            int next = Integer.parseInt(br.readLine());
            if (isLeft(next)) {
                int move = left - next;
                answer += move;
                move(-move);
            } else if (isRight(next)) {
                int move = next - right;
                answer += move;
                move(move);
            }
        }
        System.out.println(answer);
    }

    static void move(int move) {
        left += move;
        right += move;
    }

    static boolean isLeft(int next) {
        return next < left;
    }

    static boolean isRight(int next) {
        return right < next;
    }

}

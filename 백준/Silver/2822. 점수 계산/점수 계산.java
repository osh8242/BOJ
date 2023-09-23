import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static class Question implements Comparable<Question> {
        int point;
        int no;

        public Question(int point, int no) {
            this.point = point;
            this.no = no;
        }

        @Override
        public int compareTo(Question o) {
            return o.point - this.point;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Question> que = new PriorityQueue<>();
        for (int i = 1; i <= 8; i++) {
            int point = Integer.parseInt(br.readLine());
            que.add(new Question(point, i));
        }
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[9];
        for (int i = 1; i <= 5; i++) {
            Question question = que.poll();
            answer += question.point;
            nums[question.no] = question.no;
        }
        sb.append(answer).append("\n");
        for (int i = 1; i <= 8; i++) {
            if (nums[i] != 0) sb.append(nums[i]).append(" ");
        }
        System.out.println(sb);
    }
}

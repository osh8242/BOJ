import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) pq.add(Integer.parseInt(br.readLine()));
        while (pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            answer += temp;
            pq.add(temp);
        }
        System.out.println(answer);
    }

}
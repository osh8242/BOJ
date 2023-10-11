import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (st.hasMoreTokens()) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int answer = 1;
        for (int i = 0; i < 4; i++) {
            int value = pq.poll();
            if (i % 2 == 0) answer *= value;
        }
        System.out.println(answer);

    }
}

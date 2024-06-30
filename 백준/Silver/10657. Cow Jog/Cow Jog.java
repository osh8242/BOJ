import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Cow> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            pq.offer(new Cow(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        int groupCount = 1;
        Cow tail = pq.poll();
        while (!pq.isEmpty()) {
            Cow current = pq.poll();
            if (current.speed > tail.speed) {
                current.speed = tail.speed;
                tail = current;
            } else {
                groupCount++;
                tail = current;
            }
        }
        System.out.println(groupCount);
    }

    static class Cow implements Comparable<Cow> {
        int position;
        int speed;

        public Cow(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }

        @Override
        public int compareTo(Cow o) {
            return this.position - o.position;
        }
    }
}

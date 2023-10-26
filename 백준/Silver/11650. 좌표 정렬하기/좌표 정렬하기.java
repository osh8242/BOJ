import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static PriorityQueue<Point> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();

    static class Point implements Comparable<Point> {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return this.x < o.x ? -1 : this.x == o.x ? this.y < o.y ? -1 : 1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Point(x, y));
        }
        while (!pq.isEmpty()) {
            Point point = pq.poll();
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }
        System.out.println(sb);

    }

}

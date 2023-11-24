import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (st.hasMoreTokens()) pq.offer(Integer.parseInt(st.nextToken()));
        int a = pq.poll();
        int b = pq.poll();
        int c = pq.poll();
        if (a == b && b == c) System.out.println(2);
        else if (a * a + b * b == c * c) System.out.println(1);
        else System.out.println(0);
    }

}

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Queue<Integer> highQueue = new PriorityQueue<>();
        Queue<Integer> lowQueue = new PriorityQueue<>();
        while (N-- > 0) {
            highQueue.offer(Integer.parseInt(br.readLine()));
        }
        while (M-- > 0) {
            lowQueue.offer(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while (!highQueue.isEmpty()) {
            int size = highQueue.poll();
            count++;
            if (!lowQueue.isEmpty() && lowQueue.peek() < size) {
                lowQueue.poll();
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }

}

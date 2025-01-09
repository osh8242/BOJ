import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<String, Integer> scores = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            scores.put(name, score);
        }

        int sum = 0;
        for (int i = 0; i < K; i++) {
            String name = br.readLine();
            sum += scores.get(name);
            scores.remove(name);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            minHeap.offer(entry.getValue());
            maxHeap.offer(entry.getValue());
        }

        int left = M - K;
        int minSum = sum;
        for (int i = 0; i < left; i++) {
            minSum += minHeap.poll();
        }

        int maxSum = sum;
        for (int i = 0; i < left; i++) {
            maxSum += maxHeap.poll();
        }

        bw.write(minSum + " " + maxSum);
        bw.flush();
    }
}

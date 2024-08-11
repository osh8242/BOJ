import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] sums = new int[N];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < N; i++) {
            sums[i] += pq.poll();
        }
        for (int i = N - 1; i >= 0; i--) {
            sums[i] += pq.poll();
        }
        int min = sums[0];
        for (int i = 1; i < N; i++) {
            min = Math.min(min, sums[i]);
        }
        bw.write(Integer.toString(min));
        bw.flush();
    }

}

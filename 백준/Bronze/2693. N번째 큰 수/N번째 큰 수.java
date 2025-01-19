import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Queue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                que.offer(Integer.parseInt(st.nextToken()));
            }
            while (que.size() > 8) que.poll();
            sb.append(que.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
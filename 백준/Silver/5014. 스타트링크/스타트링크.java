import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[] isVisit = new int[F + 1];
        Queue<Integer> que = new PriorityQueue<>();
        isVisit[S] = 1;
        que.offer(S);
        boolean isExist = false;
        while (!que.isEmpty()) {
            int pos = que.poll();
            if (pos == G) {
                isExist = true;
                break;
            }
            if (pos - D > 0 && isVisit[pos - D] == 0) {
                isVisit[pos - D] += isVisit[pos] + 1;
                que.offer(pos - D);
            }
            if (pos + U <= F && isVisit[pos + U] == 0) {
                isVisit[pos + U] += isVisit[pos] + 1;
                que.offer(pos + U);
            }
        }

        System.out.println(isExist ? isVisit[G] - 1 : "use the stairs");
    }
}
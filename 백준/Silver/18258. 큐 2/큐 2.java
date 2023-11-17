import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Queue<Integer> que = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int last = -1;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push": {
                    int num = Integer.parseInt(st.nextToken());
                    que.offer(num);
                    last = num;
                    break;
                }
                case "pop": {
                    if (que.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(que.poll()).append("\n");
                    break;
                }
                case "size": {
                    sb.append(que.size()).append("\n");
                    break;
                }
                case "empty": {
                    sb.append(que.isEmpty() ? 1 : 0).append("\n");
                    break;
                }
                case "front": {
                    sb.append(que.isEmpty() ? -1 : que.peek()).append("\n");
                    break;
                }
                case "back": {
                    sb.append(que.isEmpty() ? -1 : last).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }

}

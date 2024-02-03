import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-->0){
            Queue<Integer> que = new PriorityQueue<>(Comparator.reverseOrder());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                que.offer(Integer.parseInt(st.nextToken()));
            }
            while(que.size() > 8) que.poll();
            sb.append(que.poll()).append("\n");
        }
        System.out.println(sb);
    }
}
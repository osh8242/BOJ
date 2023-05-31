import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node{

        long val;
        int count;
        public Node(long val, int count){
            this.val = val;
            this.count = count;
        }

    }

    static long start, end;
    static boolean[] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());
        System.out.println(bfs());
    }

    static int bfs(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(start,1));
        int answer = -1;
        while(!que.isEmpty()){
            Node node = que.poll();
            if(node.val == end && answer == -1) {
                if(answer <= 0) answer = node.count;
                else if(answer > node.count) answer = node.count;
            }
            if(node.val*2 <= end) {
                que.add(new Node(node.val*2, node.count+1));
            }
            if(node.val*10+1 <= end) {
                que.add(new Node(node.val*10+1, node.count+1));
            }

        }
        return answer;

    }

}

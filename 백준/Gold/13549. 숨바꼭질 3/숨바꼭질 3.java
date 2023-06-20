import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static class Node {
        int pos;
        int count;

        public Node(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }

    }
    static int start, end, limit;
    static boolean[] isVisit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        limit = Math.abs(start - end);
        System.out.println(bfs());
    }
    static int bfs() {
       Queue<Node> que = new LinkedList<>();
        que.add(new Node(start,0));
        isVisit[start] = true;
        while (!que.isEmpty()) {
            Node node = que.poll();
            int pos = node.pos;
            int count = node.count;
            if(node.pos == end) return node.count;
            if(pos <= 50000 && !isVisit[pos*2]) {
                isVisit[pos*2] = true;
                que.add(new Node(pos*2,count));
            }
            if(pos > 0 && !isVisit[pos-1]) {
                isVisit[pos-1] = true;
                que.add(new Node(pos-1,count+1));
            }
            if(pos < 100000 && !isVisit[pos+1]) {
                isVisit[pos+1] = true;
                que.add(new Node(pos+1,count+1));
            }
        }
        return -1;
    }
}

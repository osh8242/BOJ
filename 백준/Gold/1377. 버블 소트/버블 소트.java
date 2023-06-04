import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

    static class Node implements Comparable<Node>{
        int value;
        int index;
        public Node(int value, int index){
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            if(this.value==o.value) return this.index-o.index;
            else return this.value-o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 1 ; i <= n ; i++){
            int val = Integer.parseInt(br.readLine());
            pq.add(new Node(val,i));
        }
        int max = -1;
        for(int i = 1 ; i <= n ; i++){
            Node node = pq.poll();
            if(node.index - i > max) max = node.index-i;
        }
        System.out.println(max+1);

    }

}

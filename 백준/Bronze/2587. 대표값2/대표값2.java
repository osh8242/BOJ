import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        int rank = 0;
        for(int i = 1 ; i <= 5 ; i ++){
            int value = Integer.parseInt(br.readLine());
            sum += value;
            pq.add(value);
        }
        pq.poll();pq.poll();
        System.out.println(sum/5+"\n"+pq.poll());
    }

}

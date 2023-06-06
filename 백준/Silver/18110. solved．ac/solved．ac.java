import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cut = (int)Math.round(n*0.15);
        for(int i = 0 ; i < n ; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        for(int i = 1 ; i <= cut ; i++){
            pq.poll();
        }
        int sum = 0;
        for(int i = cut+1 ; i <= n-cut ; i++){
            sum += pq.poll();
        }
        System.out.println(Math.round((double) sum/(n-2*cut)));
    }

}

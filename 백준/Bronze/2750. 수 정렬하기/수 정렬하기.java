import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        for(int i = 1 ; i <= n ; i++){
            sb.append(pq.poll() + "\n");
        }
        System.out.println(sb);
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    static PriorityQueue<Integer> pq;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int W = getScore();
        int K = getScore();
        System.out.println(W+" "+K);
    }

    static int getScore() throws IOException {
        int answer = 0;
        pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i = 1 ; i <= 10 ; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        for(int i = 1 ; i <= 3 ; i++){
            answer += pq.poll();
        }
        return answer;
    }
}

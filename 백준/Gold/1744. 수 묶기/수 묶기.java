import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int zeroCount = 0;
        int sum = 0;
        PriorityQueue<Integer> positiveNums = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negetiveNums = new PriorityQueue<>();
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) positiveNums.add(num);
            else if (num == 1) sum++;
            else if (num < 0) negetiveNums.add(num);
            else zeroCount++;
        }
        while (positiveNums.size() > 1) {
            sum += positiveNums.poll() * positiveNums.poll();
        }
        if (!positiveNums.isEmpty()) sum += positiveNums.poll();
        while (negetiveNums.size() > 1) {
            sum += negetiveNums.poll() * negetiveNums.poll();
        }
        if (!negetiveNums.isEmpty() && zeroCount == 0) sum += negetiveNums.poll();
        System.out.println(sum);

    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int bestSum = 0;
        int bestDiff = Integer.MAX_VALUE;
        int currentSum = 0;
        for (int i = 0; i < 10; i++) {
            int score = Integer.parseInt(br.readLine());
            currentSum += score;
            int diff = Math.abs(currentSum - 100);
            if (diff < bestDiff || (diff == bestDiff && currentSum > bestSum)) {
                bestDiff = diff;
                bestSum = currentSum;
            }
        }
        System.out.println(bestSum);
    }
}
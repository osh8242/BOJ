import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] level = new int[4];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            level[i] = Integer.parseInt(input[i]);
            sum += level[i];
            if (level[i] < min) min = level[i];
            if (level[i] > max) max = level[i];
        }
        System.out.println(Math.abs(2 * (max + min) - sum));
    }
}

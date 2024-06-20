import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] piles = new int[N];
        for (int i = 0; i < N; i++) piles[i] = Integer.parseInt(br.readLine());
        int sum = Arrays.stream(piles).sum();
        int avg = sum / N;
        int answer = Arrays.stream(piles).map(e -> avg > e ? avg - e : 0).sum();
        System.out.println(answer);
    }

}

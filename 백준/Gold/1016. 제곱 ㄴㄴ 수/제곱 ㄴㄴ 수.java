import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] canBeDivided = new boolean[(int) (max - min) + 1];
        for (long i = 2; i <= Math.sqrt(max); i++) {
            long square = i * i;
            long factor = min / square;
            if (min % square != 0) factor++;
            while (factor * square <= max) {
                canBeDivided[(int) ((factor++) * square - min)] = true;
            }
        }
        int answer = 0;
        for (boolean b : canBeDivided) if (!b) answer++;
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

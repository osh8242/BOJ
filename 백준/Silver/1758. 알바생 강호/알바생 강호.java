import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tips = new int[N];
        for (int i = 0; i < N; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tips);
        long sum = 0;
        for (int rank = 1; rank <= N; rank++) {
            int tip = tips[N - rank] - (rank - 1);
            if (tip <= 0) break;
            sum += tip;
        }
        System.out.println(sum);
    }

}

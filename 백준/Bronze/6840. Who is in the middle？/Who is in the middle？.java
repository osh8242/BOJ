import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] w = new int[3];
        for (int i = 0; i < 3; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(w);
        System.out.print(w[1]);
    }
}

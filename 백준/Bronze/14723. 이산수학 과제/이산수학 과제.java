import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int count = 0;
        outer:
        for (int s = 2; ; s++) {
            for (int num = s - 1; num >= 1; num--) {
                count++;
                if (count == N) {
                    System.out.println(num + " " + (s - num));
                    break outer;
                }
            }
        }
    }
}

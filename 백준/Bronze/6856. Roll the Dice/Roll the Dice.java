import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int max = N + M;
        if (max == 10) {
            System.out.println("There is 1 way to get the sum 10.");
        } else {
            int count = Math.max(Math.min(9, Math.min(9, N) + Math.min(9, M) - 9), 0);
            System.out.println("There are " + count + " ways to get the sum 10.");
        }
    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int startIndex = 1;
        int endIndex = 1;
        int sum = 1;
        int count = 1;
        while (endIndex < N) {
            if (sum > N) {
                sum -= startIndex;
                startIndex++;
            } else if (sum < N) {
                endIndex++;
                sum += endIndex;
            } else {
                count++;
                endIndex++;
                sum += endIndex;
            }
        }
        System.out.println(count);

    }

}

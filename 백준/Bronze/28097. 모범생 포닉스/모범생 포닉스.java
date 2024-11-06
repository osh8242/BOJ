import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int sum = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        sum += 8 * (N - 1);
        sb.append(sum / 24).append(" ").append(sum % 24);

        System.out.println(sb);
    }

}

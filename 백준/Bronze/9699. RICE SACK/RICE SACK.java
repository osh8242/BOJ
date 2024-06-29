import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            sb.append("Case #")
                    .append(i)
                    .append(": ")
                    .append(Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .reduce(0, Math::max))
                    .append("\n");
        }
        System.out.println(sb);
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().split(" ");
        Map<String, Integer> count = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < N; i++) {
            String size = parts[i];
            int f = count.getOrDefault(size, 0) + 1;
            count.put(size, f);
            if (f > maxFreq) maxFreq = f;
        }
        System.out.print(maxFreq);
    }
}

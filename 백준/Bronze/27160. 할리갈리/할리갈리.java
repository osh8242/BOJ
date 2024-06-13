import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            int N = Integer.parseInt(br.readLine());

            Map<String, Integer> fruitCounts = new HashMap<>();
            fruitCounts.put("STRAWBERRY", 0);
            fruitCounts.put("BANANA", 0);
            fruitCounts.put("LIME", 0);
            fruitCounts.put("PLUM", 0);

            boolean shouldRingBell = false;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String fruit = st.nextToken();
                int count = Integer.parseInt(st.nextToken());

                fruitCounts.put(fruit, fruitCounts.get(fruit) + count);
            }

            for (Integer value : fruitCounts.values()) {
                if (value == 5) {
                    shouldRingBell = true;
                    break;
                }
            }
            bw.write(shouldRingBell ? "YES" : "NO");
            bw.flush();
        }
    }
}

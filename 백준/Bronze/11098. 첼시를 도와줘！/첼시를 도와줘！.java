import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int p = Integer.parseInt(br.readLine());
            int maxPrice = Integer.MIN_VALUE;
            String bestPlayer = "none";
            for (int i = 1; i <= p; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int price = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                if (price > maxPrice) {
                    maxPrice = price;
                    bestPlayer = name;
                }
            }
            sb.append(bestPlayer).append("\n");
        }
        System.out.println(sb);
    }
}

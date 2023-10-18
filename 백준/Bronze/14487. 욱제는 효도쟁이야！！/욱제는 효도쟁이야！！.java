import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int maxPrice = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int price = Integer.parseInt(st.nextToken());
            answer += price;
            maxPrice = maxPrice < price ? price : maxPrice;
        }
        answer -= maxPrice;
        System.out.println(answer);
    }
}

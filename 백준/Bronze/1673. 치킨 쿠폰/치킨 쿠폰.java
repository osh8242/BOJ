import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String line = "";
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int coupons = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int chickens = 0;
            int stamps = 0;
            while (coupons > 0 || stamps >= k) {
                chickens += coupons;
                stamps += coupons;
                coupons = stamps / k;
                stamps = stamps % k;
            }
            System.out.println(chickens);
        }
    }
}

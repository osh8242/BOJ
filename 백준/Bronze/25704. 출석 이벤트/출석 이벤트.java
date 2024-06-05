import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(getPrice(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
    }

    static int getPrice(int coupon, int price) {
        int result = price;
        if (coupon >= 5) {
            result = price - 500;
        }
        if (coupon >= 10) {
            result = Math.min(result, (int) (price * 0.9));
        }
        if (coupon >= 15) {
            result = Math.min(result, price - 2000);
        }
        if (coupon >= 20) {
            result = Math.min(result, (int) (price * 0.75));
        }
        return Math.max(0, result);
    }

}

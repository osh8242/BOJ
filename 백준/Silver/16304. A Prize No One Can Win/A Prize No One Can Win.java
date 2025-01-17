import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] price = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < price.length; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        if (n == 1) {
            System.out.println(1);
        } else {
            Arrays.sort(price);
            int i = binarySearch(price, X);
            System.out.println(i);
        }
    }

    static int binarySearch(int[] price, int X) {
        int low = 1;
        int high = price.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (price[mid] + price[mid-1] <= X) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}

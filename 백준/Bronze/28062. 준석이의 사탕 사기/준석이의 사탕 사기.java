import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int minOdd = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            sum += a;
            if ((a & 1) == 1 && a < minOdd) {
                minOdd = a;
            }
        }
        int result;
        if ((sum & 1) == 0) {
            result = sum;
        } else if (minOdd == Integer.MAX_VALUE) {
            result = 0;
        } else {
            result = sum - minOdd;
        }
        System.out.println(result);
    }
}
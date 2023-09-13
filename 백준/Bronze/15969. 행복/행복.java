import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int tc = 1; tc <= N; tc++) {
            int value = Integer.parseInt(st.nextToken());
            minValue = minValue > value ? value : minValue;
            maxValue = maxValue < value ? value : maxValue;
        }
        System.out.println(maxValue - minValue);
    }

}

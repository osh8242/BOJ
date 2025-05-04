import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int sheep = -1;
        int goat = -1;
        int count = 0;

        for (int x = 1; x < n; x++) {
            int y = n - x;
            if (a * x + b * y == w) {
                sheep = x;
                goat = y;
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (count == 1) {
            sb.append(sheep).append(' ').append(goat);
        } else {
            sb.append(-1);
        }
        System.out.println(sb);
    }
}

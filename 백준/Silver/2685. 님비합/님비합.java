import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            String[] parts = br.readLine().split(" ");
            int B = Integer.parseInt(parts[0]);
            long X = Long.parseLong(parts[1]);
            long Y = Long.parseLong(parts[2]);
            long result = 0;
            long place = 1;
            while (X > 0 || Y > 0) {
                int dx = (int)(X % B);
                int dy = (int)(Y % B);
                int d = (dx + dy) % B;
                result += d * place;
                place *= B;
                X /= B;
                Y /= B;
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        int prev = -1;
        while (N-- > 0) {
            int current = Integer.parseInt(st.nextToken());
            if (prev <= current) count++;
            prev = current;
        }
        System.out.println(count);
    }

}

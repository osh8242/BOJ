import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while (N-- > 0) {
            int d = Integer.parseInt(br.readLine());
            if ((d & 1) == 1) count++;
        }
        System.out.println(count);
    }

}

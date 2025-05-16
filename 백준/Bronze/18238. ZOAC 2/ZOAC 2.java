import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int time = 0;
        int cur = 0;
        
        for (char ch : s.toCharArray()) {
            int target = ch - 'A';
            int diff = Math.abs(target - cur);
            time += Math.min(diff, 26 - diff);
            cur = target;
        }

        System.out.println(time);
    }
}

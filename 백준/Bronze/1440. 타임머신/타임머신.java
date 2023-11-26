import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int hour = 0;
        int minute = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0 && num < 13) hour++;
            else if (num < 60) minute++;
        }
        System.out.println(hour + minute == 3 ? hour * 2 : 0);
    }

}

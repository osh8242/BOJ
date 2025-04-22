import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String line;
        int count = 0;
        while ((line = br.readLine()).length() != 10) {
            int length = line.length();
            if (length == 2) count++;
            else if (count > 0) count--;
            else count += 2;
        }
        System.out.println(count == 0 ? "고무오리야 사랑해" : "힝구");
    }
}

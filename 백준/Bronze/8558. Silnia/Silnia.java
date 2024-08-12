import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int lastDigit = 1;

        for (int i = 2; i <= n; i++) {
            lastDigit = (lastDigit * i) % 10;
            if (lastDigit == 0) break;
        }

        bw.write(Integer.toString(lastDigit));
        bw.flush();
    }
}

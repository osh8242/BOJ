import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        int B = Integer.parseInt(input[1]);

        StringBuilder result = new StringBuilder();

        while (N > 0) {
            long remainder = N % B;
            if (remainder >= 10) {
                result.append((char) ('A' + (remainder - 10)));
            } else {
                result.append(remainder);
            }
            N /= B;
        }

        bw.write(result.reverse().toString());
        bw.flush();
    }
}

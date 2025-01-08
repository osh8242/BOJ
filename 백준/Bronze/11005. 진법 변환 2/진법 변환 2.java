import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[64];
        int len = System.in.read(buffer);
        
        long N = 0;
        int B = 0;
        int idx = 0;

        while (buffer[idx] != ' ') {
            N = N * 10 + (buffer[idx] - '0');
            idx++;
        }
        idx++;
        while (idx < len && buffer[idx] != '\n') {
            B = B * 10 + (buffer[idx] - '0');
            idx++;
        }

        StringBuilder result = new StringBuilder();

        while (N > 0) {
            long remainder = N % B;
            if (remainder >= 10) {
                result.append((char) ('A' + (remainder - 10)));
            } else {
                result.append((char) ('0' + remainder));
            }
            N /= B;
        }

        System.out.write(result.reverse().toString().getBytes());
    }
}

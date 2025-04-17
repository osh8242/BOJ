import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        char ch = line.charAt(0);

        final int BASE = 0xAC00;
        final int N_V = 21;
        final int N_T = 28;

        int offset = ch - BASE;
        int L = offset / (N_V * N_T);
        int V = (offset % (N_V * N_T)) / N_T;
        int T = offset % N_T;

        int index = L * N_V * N_T + V * N_T + T + 1;
        System.out.println(index);
    }
}
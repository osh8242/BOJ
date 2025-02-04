import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int half = N / 2;
        for (int i = 0; i < half; i++) {
            sb.append('a');
        }
        bw.write(sb.toString());
        if (N % 2 != 0) sb.append('a');
        bw.write(sb.toString());
        bw.flush();
    }
}

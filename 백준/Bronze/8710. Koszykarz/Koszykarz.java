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
        long k = Long.parseLong(input[0]);
        long w = Long.parseLong(input[1]);
        long m = Long.parseLong(input[2]);

        long difference = w - k;
        long hits = (difference + m - 1) / m;  // 올림 처리로 필요한 최소 타격 수 계산

        bw.write(String.valueOf(hits));
        bw.flush();
    }
}

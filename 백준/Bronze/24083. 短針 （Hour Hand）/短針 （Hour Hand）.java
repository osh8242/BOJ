import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        int C = A + B;
        while (C > 12) C -= 12;
        sb.append(C);

        bw.write(sb.toString());
        bw.flush();
    }

}

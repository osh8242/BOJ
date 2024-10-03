import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] chars = br.readLine().toCharArray();
            boolean doIt = false;
            for (int i = 0; i < chars.length / 2; i++) {
                doIt = chars[i] == chars[chars.length - 1 - i];
            }
            sb.append(doIt ? "Do-it" : "Do-it-Not").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

}

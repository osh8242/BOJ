import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {
            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                String input = br.readLine();
                String word1 = input.substring(0, input.indexOf(" ") + 1);
                input = input.substring(input.indexOf(" ") + 1);
                String word2 = input.substring(0, input.indexOf(" ") + 1);
                input = input.substring(input.indexOf(" ") + 1);
                sb.append(input).append(" ").append(word1).append(word2).append("\n");                
            }
            bw.write(sb.toString());
            bw.flush();
        }
    }
}

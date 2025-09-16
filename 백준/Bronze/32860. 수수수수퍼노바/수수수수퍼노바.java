import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        sb.append("SN ").append(N);
        
        if (M <= 26) {
            char code = (char)('A' + M - 1);
            sb.append(code);
        } else {
            int adjustedM = M - 27;
            char first = (char)('a' + adjustedM / 26);
            char second = (char)('a' + adjustedM % 26);
            sb.append(first).append(second);
        }
        
        System.out.println(sb.toString());
    }
}

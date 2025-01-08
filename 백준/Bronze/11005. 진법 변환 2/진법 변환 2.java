import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int code = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num % code < 10) sb.append(num % code);
            else sb.append((char) (num % code + 55));
            num -= num % code;
            num /= code;
        }
        System.out.println(sb.reverse());
    }

}
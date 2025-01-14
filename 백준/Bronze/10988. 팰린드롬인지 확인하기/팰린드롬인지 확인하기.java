import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();

        int s = 0;
        int e = len - 1;
        while (s < e) {
            if (str.charAt(s++) != str.charAt(e--)) {
                System.out.println(0); // 회문이 아닌 경우
                return;
            }
        }
        System.out.println(1); // 회문인 경우
    }
}

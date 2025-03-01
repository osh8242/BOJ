import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s = br.readLine();
        int num = 0;
        int ch = 0;
        for (char c : s.toCharArray()) {
            if (c == '2') num++;
            else if (c == 'e') ch++;
        }
        System.out.println(num > ch ? '2' : ch > num ? 'e' : "yee");
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cn = Integer.parseInt(br.readLine());
        int n = 1;
        while (cn != 1) {
            n++;
            if (cn % 2 == 0) cn = cn / 2;
            else cn = 3 * cn + 1;
        }
        System.out.println(n);
    }
}

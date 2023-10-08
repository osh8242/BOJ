import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        String line = br.readLine();
        int a = 0;
        int b = 0;
        for (int i = 0; i < T; i++) {
            if (line.charAt(i) == 'A') a++;
            else b++;
        }
        if (a == b) System.out.println("Tie");
        else if (a > b) System.out.println("A");
        else System.out.println("B");
    }
}

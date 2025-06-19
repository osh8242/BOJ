import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = br.readLine().charAt(0);
        if (c == 'N' || c == 'n') {
            System.out.print("Naver D2");
        } else {
            System.out.print("Naver Whale");
        }
    }
}

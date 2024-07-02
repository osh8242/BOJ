import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long input = Long.parseLong(br.readLine());
        boolean is33 = input > 0;
        while (input > 0) {
            if (input % 3 == 0) {
                input = input / 3;
            } else if (input % 3 == 1){
                input--;
            } else {
                is33 = false;
                break;
            }
        }
        System.out.println(is33 ? "YES" : "NO");
    }
}

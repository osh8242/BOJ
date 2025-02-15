import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int count = 0;
        while ((input = br.readLine()) != null) {
            count++;
        }
        System.out.println(count);
    }
}

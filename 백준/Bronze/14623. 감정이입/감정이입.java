import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long B1 = Long.parseLong(br.readLine(), 2);
        Long B2 = Long.parseLong(br.readLine(), 2);
        System.out.println(Long.toBinaryString(B1*B2));
    }
}
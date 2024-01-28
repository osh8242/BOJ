import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int a = input[0] - '0';
        int b = input[1] - '0';
        if (input[1] == '0') {
            a = 10;
            b = input[2] - '0';
        }
        if (input[input.length - 1] == '0') {
            b = 10;
        }
        System.out.println(a + b);
    }
}
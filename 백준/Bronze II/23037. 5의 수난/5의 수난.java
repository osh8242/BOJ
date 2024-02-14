import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] digits = br.readLine().toCharArray();
        int answer = 0;
        for (char digit : digits) {
            answer += (int) Math.pow(digit - '0', 5);
        }
        System.out.println(answer);
    }
}
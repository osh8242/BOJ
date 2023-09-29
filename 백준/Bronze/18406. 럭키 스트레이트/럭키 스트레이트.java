import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {
        String inputLine = br.readLine();
        int leftSum = 0;
        for (int i = 0; i < inputLine.length() / 2; i++) {
            leftSum += Character.getNumericValue(inputLine.charAt(i));
        }
        int rightSum = 0;
        for (int i = inputLine.length() / 2; i < inputLine.length(); i++) {
            rightSum += Character.getNumericValue(inputLine.charAt(i));
        }
        System.out.println(leftSum == rightSum ? "LUCKY" : "READY");
    }
}

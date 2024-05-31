import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int left = 0;
        for(char ch : line.substring(0, line.indexOf('(')).toCharArray()) {
            if(ch == '@') left++;
        }
        int right = 0;
        for(char ch : line.substring(line.indexOf(')')).toCharArray()) {
            if(ch == '@') right++;
        }
        System.out.printf(String.format("%d %d", left, right));
    }

}

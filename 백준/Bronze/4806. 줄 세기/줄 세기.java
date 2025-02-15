import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int c;
        boolean lastWasNewLine = true;
        while ((c = br.read()) != -1) {
            if (c == '\n') {
                count++;
                lastWasNewLine = true;
            } else {
                lastWasNewLine = false;
            }
        }
        if (!lastWasNewLine) {
            count++;
        }
        System.out.println(count);
    }
}

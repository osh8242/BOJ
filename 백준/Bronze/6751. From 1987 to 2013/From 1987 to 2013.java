import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        while (!isDistinct(++year)) {
        }
        System.out.println(year);
    }

    static boolean isDistinct(int year) {
        char[] temp = String.valueOf(year).toCharArray();
        for (int i = 0; i < temp.length - 1; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[i] == temp[j]) return false;
            }
        }
        return true;
    }

}

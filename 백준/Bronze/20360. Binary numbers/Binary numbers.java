import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < 20 ; i ++) {
            if(((input & 1) == 1)) sb.append(i).append(" ");
            input = input >> 1;
        }

        System.out.println(sb);
    }

}

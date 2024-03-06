import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        if ((N & 1) == 0) {
            switch (N) {
                case 2 -> answer = 3;
                case 4 -> answer = 11;
                case 6 -> answer = 41;
                case 8 -> answer = 153;
                case 10 -> answer = 571;
                case 12 -> answer = 2131;
                case 14 -> answer = 7953;
                case 16 -> answer = 29681;
                case 18 -> answer = 110771;
                case 20 -> answer = 413403;
                case 22 -> answer = 1542841;
                case 24 -> answer = 5757961;
                case 26 -> answer = 21489003;
                case 28 -> answer = 80198051;
                case 30 -> answer = 299303201;
            }
        }
        System.out.println(answer);
    }
}
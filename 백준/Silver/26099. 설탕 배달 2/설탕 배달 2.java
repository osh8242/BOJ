import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long N = 0;
        long answer = -1;
        int input;

        while ((input = System.in.read()) != '\n') {
            if (input >= '0' && input <= '9') {
                N = N * 10 + (input - '0');
            }
        }

        long q = N / 5;
        int r = (int) (N % 5);

        switch (r) {
            case 0: 
                answer = q; 
                break;
            case 1: 
                if (q > 0) answer = q + 1; 
                break;
            case 2: 
                if (q > 1) answer = q + 2; 
                break;
            case 3: 
                answer = q + 1; 
                break;
            case 4: 
                if (q > 0) answer = q + 2; 
                break;
        }

        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        int a = time / 300;
        time %= 300;
        int b = time / 60;
        time %= 60;
        if(time%10 != 0) {
            System.out.println(-1);
            return;
        }
        int c = time / 10;
        System.out.println(a+" "+b+" "+c);

    }
}

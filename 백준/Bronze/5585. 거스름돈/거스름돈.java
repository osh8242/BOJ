import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = 1000-Integer.parseInt(br.readLine());
        int unit = 500;
        boolean mode = true;
        int count = 0;
        while(change>0){
            count += change/unit;
            change %= unit;
            unit /= mode ? 5 : 2;
            mode = !mode;
        }
        System.out.println(count);
    }
}

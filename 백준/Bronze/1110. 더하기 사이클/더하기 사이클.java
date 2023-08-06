import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int temp = num;
        int count = 0;
        while(true){
            int sum = temp/10 + temp%10;
            temp = temp%10*10 + sum%10;
            count++;
            if(temp == num) break;
        }
        System.out.println(count);

    }

}

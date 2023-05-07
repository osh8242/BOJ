import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            double num = Double.parseDouble(br.readLine());
            double ref = num;
            if(num == 0.0) break;
            double sum = 1;
            for (int i = 0 ; i < 4 ; i++){
                sum += num;
                num *= ref;
            }
            System.out.printf("%.2f\n",sum);
        }
    } // void main()
} //Class Main
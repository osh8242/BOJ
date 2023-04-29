import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] series = new int[n+1];
        if(n == 1) {
            System.out.println(1);
            return;
        }
        if(n==2){
            System.out.println(3);
            return;
        }
        series[1] = 1;
        series[2] = 3;
        for(int i =3 ; i <= n ; i++){
            series[i] = series[i-1] + 2*series[i-2];
            if (series[i] > 10007) series[i] %= 10007;
        }
        System.out.println(series[n]);
    }
}
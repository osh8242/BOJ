import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println(9);
            return;
        }
        int[] side = new int[n+1];
        side[1] = 3;
        for(int i = 2 ; i <=n ; i++){
            side[i] = 2*side[i-1]-1;
        }
        System.out.println(side[n]*side[n]);

    }

}

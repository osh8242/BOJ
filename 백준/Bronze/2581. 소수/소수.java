import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int min = -1;
        int sum = 0;
        for(int i = m ; i <= n ; i++){
            if(isPrime(i)) {
                sum += i;
                if(min == -1) min = i;
            }
        }
        if(min != -1) System.out.println(sum+"\n"+min);
        else System.out.println(-1);


    }//main

    static boolean isPrime(int num){
        if(num==1) return false;
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num%i == 0) return false;
        }
        return true;
    }

}//Class
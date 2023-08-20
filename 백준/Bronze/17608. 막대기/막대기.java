import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sticks = new int[n];
        for(int i = 0 ; i < n ; i++){
            sticks[i]= Integer.parseInt(br.readLine());
        }
        int count = 0;
        int refHeight = Integer.MIN_VALUE;
        for(int i = n-1 ; i >= 0 ; i--){
            if(sticks[i] > refHeight) {
                refHeight = sticks[i];
                count++;
            }
        }
        System.out.println(count);

    }

}

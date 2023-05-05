import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int ijSum = 2;
        while(true){
            if((ijSum)*(ijSum-1)/2 >= x) break;
            else ijSum++;
        }
        int i = x - (ijSum-1)*(ijSum-2)/2;
        int j = ijSum - i;
        if(ijSum%2==1) System.out.println(i + "/" + j);
        else System.out.println(j + "/" + i);

    }

}

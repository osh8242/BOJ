import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String hexaNum = br.readLine();
        int deciNum = 0;
        int digitMultiple = 1;
        for(int i = hexaNum.length()-1 ; i >= 0 ; i--){
            char digit = hexaNum.charAt(i);
            if(digit>=65) digit -= 55;
            else digit -= 48;
            deciNum += digit*digitMultiple;
            digitMultiple *= 16;
        }
        System.out.println(deciNum);
    }
}
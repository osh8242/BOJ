import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] str_arr = new String[5];
        int maxLength = 0;
        for(int i = 0 ; i < 5 ; i++){
            str_arr[i] = br.readLine();
            if(str_arr[i].length() > maxLength) maxLength = str_arr[i].length();
        }
        for(int j = 0 ; j < maxLength ; j++){
            for(int i = 0 ; i < 5 ; i++){
                if(j < str_arr[i].length()) sb.append(str_arr[i].charAt(j));
            }
        }
        System.out.println(sb.toString());

    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int mode = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i = 0 ; i < str.length() ; i++){
            char temp = str.charAt(i);
            int value = 0;
            if(temp > 64) value = (temp - 55);
            else value = temp - 48;
            for(int j = str.length()-1-i ; j > 0 ; j--){
                value *= mode;
            }
            sum += value;
        }
        System.out.println(sum);

    }

}
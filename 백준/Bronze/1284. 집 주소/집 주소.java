import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String num = br.readLine();
            int value = Integer.parseInt(num);
            if(value == 0) break;
            int width = num.length() + 1;
            for(int i = 0 ; i < num.length() ; i++){
                switch(num.charAt(i)){
                    case '0' : width += 2;
                    case '1' : width += 2; break;
                    default : width += 3;
                }
            }
            sb.append(width+"\n");
        }
        System.out.println(sb);
    }//main(){}

}//class Main{}

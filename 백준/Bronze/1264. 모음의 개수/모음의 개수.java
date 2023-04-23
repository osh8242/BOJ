import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp;

        while((temp = br.readLine().toLowerCase()).charAt(0) != '#'){
            int count = 0;
            for(int i = 0 ; i < temp.length() ; i++){
                char ch = temp.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    count++;
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb.toString());

    }

}
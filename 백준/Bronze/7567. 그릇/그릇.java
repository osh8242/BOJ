import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int height = 10;
        String input = br.readLine();
        char ch = input.charAt(0);
        for(int i = 1 ; i < input.length() ; i++){
            if(ch == input.charAt(i)) height +=5;
            else {
                height += 10;
                ch = input.charAt(i);
            }
        }
        System.out.println(height);

    }

}

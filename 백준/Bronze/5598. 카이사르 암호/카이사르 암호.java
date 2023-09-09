import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        for(int i = 0 ; i < chars.length ;i ++){
            switch (chars[i]){
                case 'A':
                case 'B':
                case 'C':
                    chars[i] = (char)(chars[i]+23);
                    break;
                default:
                    chars[i] = (char)(chars[i]-3);
            }
        }
        System.out.println(new String(chars));

    }

}

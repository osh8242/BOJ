import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int count = 0;
        for(int i = 0 ; i < str.length() ; i++){
            if(i==str.length()-1) {
                count++;
                break;
            }
            boolean isCroatia = true;
            for(int j = 0 ; j < croatia.length ; j++){
                isCroatia = true;
                if(i==str.length()-2 && j == 2) continue;
                for(int k = 0 ; k < croatia[j].length() ; k++){
                    if(str.charAt(i+k) != croatia[j].charAt(k)){
                        isCroatia = false;
                        break;
                    }
                }
                if(isCroatia){
                    count++;
                    i += croatia[j].length()-1;
                    break;
                }
            }
            if(!isCroatia) count++;
        }
        System.out.println(count);

    }
}
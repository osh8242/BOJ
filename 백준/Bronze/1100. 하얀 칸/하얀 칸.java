import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        for(int i = 1 ; i <= 8 ; i++){
            String line = br.readLine();
            for(int j = 1 ; j <= 8 ; j++){
                if((i+j)%2==0 && line.charAt(j-1) == 'F') answer++;
            }
        }
        System.out.println(answer);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= 3 ; i++){
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 4 ; j++){
                if(st.nextToken().charAt(0) == '0') count++;
            }
            if(count >= 1) sb.append((char)(64+count)+"\n");
            else sb.append((char)'E'+"\n");
        }
        System.out.println(sb);

    }

}

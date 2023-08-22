import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= T ; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            float n = Float.parseFloat(st.nextToken());
            while(st.hasMoreTokens()){
                switch (st.nextToken().charAt(0)){
                    case '@' :
                        n *= 3;
                        break;
                    case '%' :
                        n += 5;
                        break;
                    case '#' :
                 n -= 7;
                        break;
                }
            }
            System.out.printf("%.2f\n",n);
        }
    }

}

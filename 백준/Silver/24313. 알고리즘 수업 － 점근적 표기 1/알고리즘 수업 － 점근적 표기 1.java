import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        boolean isSatisfying = true;
        int d = (c-a1)*n0 - a0;
        for(int i = n0 ; i <= 100 ; i++){
            if((c-a1)*i - a0 < 0) {
                isSatisfying = false;
                break;
            }
        }
        if(isSatisfying) System.out.println(1);
        else System.out.println(0);
    }

}

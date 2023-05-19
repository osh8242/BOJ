import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int d = 0;
        int p = 0;
        for(int i = 1 ; i <= n ; i++){
            char result = br.readLine().charAt(0);
            switch (result){
                case 'D': d += 1; break;
                case 'P': p += 1;
            }
            if(Math.abs(d-p) >= 2) break;
        }
        System.out.println(d+":"+p);
    }
}
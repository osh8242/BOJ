import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int an = Integer.parseInt(st.nextToken());
        int ad = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int bn = Integer.parseInt(st.nextToken());
        int bd = Integer.parseInt(st.nextToken());
        int gcd = getGCD(ad,bd);
        int denominator = bd*ad/gcd;
        int numerator = (an*bd + bn*ad)/gcd;
        gcd = getGCD(numerator, denominator);
        System.out.println(numerator/gcd + " " +  denominator/gcd);
    }

    static int getGCD(int a, int b){
        int answer = 1;
        for(int i = 2 ; i <= Math.min(a,b) ; i++){
            if(a%i==0 && b%i==0) answer = i;
        }
        return answer;
    }

}

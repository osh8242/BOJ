import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static long a;
    static int b,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        a %= c;
        System.out.println(recursiveMultiply(a,b));

    }

    static long recursiveMultiply(long val, int exp){
        if(exp == 1) return val;
        long temp = recursiveMultiply(val, exp/2)%c;
        if(exp%2==1) return ((temp)*(temp)%c)*a%c;
        else return (temp)*(temp)%c;
    }

}

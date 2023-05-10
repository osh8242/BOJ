import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 1 ; t <= 3 ; t++){
            int n = Integer.parseInt(br.readLine());
            BigInteger sum = new BigInteger("0");
            for(int i = 1 ; i <= n ; i++){
               sum = sum.add(new BigInteger(br.readLine()));
            }
            int determine = sum.compareTo(BigInteger.ZERO);
            if(determine==-1) sb.append("-\n");
            else if(determine==1) sb.append("+\n");
            else sb.append("0\n");
        }
        System.out.println(sb.toString());

    } // void main()
} //Class Main
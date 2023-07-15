import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = 7;
        int oddSum = 0;
        int oddMin = Integer.MAX_VALUE;
        while(line-- > 0){
            int num = Integer.parseInt(br.readLine());
            if(num%2 == 1) {
                oddSum += num;
                oddMin = oddMin > num ? num : oddMin;
            }
        }
        if(oddSum == 0) System.out.println(-1);
        else System.out.println(oddSum+"\n"+oddMin);
    }

}

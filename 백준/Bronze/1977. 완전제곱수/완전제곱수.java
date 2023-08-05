import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());
        boolean isExist = false;
        int sum = 0;
        int minNum = -1;
        for(int i = start ; i <= end ; i++){
            if(isSquared(i)){
                sum += i;
                if(!isExist){
                    minNum = i;
                    isExist = true;
                }
            }
        }
        System.out.println(isExist ? sum + "\n" + minNum : minNum);
    }

    static boolean isSquared(int num){
        int factor = (int)Math.sqrt(num);
        return factor * factor == num ? true : false;
    }
}

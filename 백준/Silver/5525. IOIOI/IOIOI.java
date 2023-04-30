import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 2*n+1;
        boolean isStart = false;
        boolean waitO = false;
        int answer = 0;
        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int index = 0 ; index < str.length() ; index++){
            if(isStart && ((str.charAt(index) == 'O' && waitO) || (str.charAt(index) == 'I' && !waitO) ) ){
                count--;
                waitO = !waitO;
                if(count == 0) {
                    answer++;
                    count = 2;
                }
            } else if(isStart && str.charAt(index) == 'I'){
                count = 2*n;
            } else if(isStart && str.charAt(index) == 'O'){
                isStart = !isStart;
                count = 2*n+1;
                continue;
            }

            if(str.charAt(index) == 'I' && !isStart){
                count--;
                isStart = true;
                waitO = true;
            }
        }
        System.out.println(answer);
    }

}

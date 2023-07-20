import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= num ; i++){
            for(int j = num-i ; j >= 1 ; j--){
                sb.append(" ");
            }
            sb.append("*");
            if(i==1) {
                sb.append("\n");
                continue;
            }

            if(i>1 && i == num) {
                for(int j = 1 ; j <= 2*(num-1) ; j++){
                    sb.append("*");
                }
            } else {
                for(int j = 1 ; j <= 2*(i-1)-1 ; j++){
                    sb.append(" ");
                }
                sb.append("*");
            }
            sb.append("\n");

        }
        System.out.println(sb);

    }
}

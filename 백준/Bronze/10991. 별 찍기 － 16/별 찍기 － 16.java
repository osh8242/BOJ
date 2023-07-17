import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= n ; i++){
            for(int space = n-i ; space >= 1 ; space--){
                sb.append(" ");
            }
            sb.append("*");
            for(int star = i-1 ; star >= 1 ; star--){
                sb.append(" *");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}

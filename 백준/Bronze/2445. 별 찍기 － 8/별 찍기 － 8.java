import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= 2*n-1 ; i++){
            int index = i<=n?i:2*n-i;
            for(int j = 1 ; j <= index ; j++){
                sb.append("*");
            }
            for(int j = 1 ; j <= 2*(n-index) ; j++){
                sb.append(" ");
            }
            for(int j = 1 ; j <= index ; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

}

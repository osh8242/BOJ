import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if(n==1) {System.out.println("*"); return;}
        sb = new StringBuilder();
        boolean mode = true;
        for(int i = 1 ; i <= 2*n ; i++){
            append(mode);
            mode = !mode;
        }
        System.out.println(sb);

    }

    static void append(boolean mode){
        for(int i = 1 ; i <= n ; i++){
            sb.append(mode ? "*" : " ");
            mode =! mode;
        }
        sb.append("\n");
    }
}

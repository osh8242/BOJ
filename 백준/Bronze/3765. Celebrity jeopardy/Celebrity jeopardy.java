import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp;
        while((temp = br.readLine()) != null){
            sb.append(temp+"\n");
        }
        System.out.println(sb);
    }

}

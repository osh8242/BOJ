import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String temp = "";
        while (!(temp = br.readLine()).equals("# 0 0")){
            String[] profile = temp.split(" ");
            if(Integer.parseInt(profile[1])>17 || Integer.parseInt(profile[2])>=80){
                sb.append(profile[0]+" Senior\n");
            } else sb.append(profile[0]+" Junior\n");
        }
        System.out.println(sb.toString());
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main
{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine()));
    }
}
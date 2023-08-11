import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = (Integer.parseInt(br.readLine())/100)*100;
        int f = Integer.parseInt(br.readLine());
        while(n%f != 0){
            n++;
        }
        int answer = n%100;
        System.out.println(answer < 10 ? "0" + answer : answer);


    }

}

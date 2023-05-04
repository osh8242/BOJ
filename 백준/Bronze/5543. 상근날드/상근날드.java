import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int burgerMin = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= 2 ; i ++){
            int temp = Integer.parseInt(br.readLine());
            if(temp < burgerMin) burgerMin = temp;
        }
        int drinkMin = Integer.parseInt(br.readLine());
        int temp = Integer.parseInt(br.readLine());
        if (drinkMin > temp) System.out.println(burgerMin+temp-50);
        else System.out.println(burgerMin+drinkMin-50);

    }

}
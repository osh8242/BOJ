import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double total_mass = 0;
        double mass_sum = 0;
        for(int i =1 ; i <= 20 ; i++){
            String[] str = br.readLine().split(" ");
            if(str[2].charAt(0) == 'P') continue;
            else if(str[2].charAt(0) == 'F'){
                total_mass += Double.parseDouble(str[1]);
                continue;
            }
            double mass = 69-str[2].charAt(0);
            if((str[2].charAt(1))=='+') mass += 0.5;
            mass_sum += Double.parseDouble(str[1])*mass;
            total_mass += Double.parseDouble(str[1]);

        }
        System.out.printf("%f",mass_sum/total_mass);

    }
}
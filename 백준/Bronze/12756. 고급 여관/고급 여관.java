import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int attackA = Integer.parseInt(st.nextToken());
        int lifeA = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int attackB = Integer.parseInt(st.nextToken());
        int lifeB = Integer.parseInt(st.nextToken());
        
        int turnsA = (lifeA + attackB - 1) / attackB;
        
        int turnsB = (lifeB + attackA - 1) / attackA;
        
        if (turnsA < turnsB) {
            System.out.println("PLAYER B");
        } else if (turnsA > turnsB) {
            System.out.println("PLAYER A");
        } else {
            System.out.println("DRAW");
        }
    }

}

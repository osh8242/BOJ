import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int antenna = Integer.parseInt(br.readLine());
        int eyes = Integer.parseInt(br.readLine());
        if(antenna >= 3 && eyes <= 4){
            sb.append("TroyMartian\n");
        }
        if(antenna <= 6 && eyes >= 2){
            sb.append("VladSaturnian\n");
        }
        if (antenna <= 2 && eyes <= 3){
            sb.append("GraemeMercurian\n");
        }
        System.out.println(sb);

    }

}

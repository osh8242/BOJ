import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] current = br.readLine().split(" ");
        int currX = Integer.parseInt(current[0]);
        int currY = Integer.parseInt(current[1]);
        int closeX = 0, closeY = 0;
        double minDist = Double.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            String[] planet = br.readLine().split(" ");
            int planetX = Integer.parseInt(planet[0]);
            int planetY = Integer.parseInt(planet[1]);
            double dist = Math.sqrt(Math.pow(currX - planetX, 2) + Math.pow(currY - planetY, 2));
            if(dist < minDist) {
                minDist = dist;
                closeX = planetX;
                closeY = planetY;
            }
        }
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.00");
        sb.append(currX).append(" ").append(currY).append("\n");
        sb.append(closeX).append(" ").append(closeY).append("\n");
        sb.append(df.format(minDist));
        System.out.println(sb.toString());
    }
}

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int troutPoints = Integer.parseInt(br.readLine());
        int pikePoints = Integer.parseInt(br.readLine());
        int pickerelPoints = Integer.parseInt(br.readLine());
        int totalPoints = Integer.parseInt(br.readLine());

        int count = 0;

        for (int trout = 0; trout * troutPoints <= totalPoints; trout++) {
            for (int pike = 0; pike * pikePoints <= totalPoints; pike++) {
                for (int pickerel = 0; pickerel * pickerelPoints <= totalPoints; pickerel++) {
                    int total = trout * troutPoints + pike * pikePoints + pickerel * pickerelPoints;
                    
                    if (total <= totalPoints && (trout > 0 || pike > 0 || pickerel > 0)) {
                        bw.write(trout + " Brown Trout, " + pike + " Northern Pike, " + pickerel + " Yellow Pickerel\n");
                        count++;
                    }
                }
            }
        }

        bw.write("Number of ways to catch fish: " + count + "\n");        
        bw.flush();
    }
}

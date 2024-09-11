import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int trout, pike, pickerel, totalPoint;
    static int way = 0;

    public static void main(String[] args) throws IOException {
        trout = Integer.parseInt(br.readLine());
        pike = Integer.parseInt(br.readLine());
        pickerel = Integer.parseInt(br.readLine());
        totalPoint = Integer.parseInt(br.readLine());

        for (int t = 0; t * trout <= totalPoint; t++) {
            for (int p = 0; p * pike <= totalPoint; p++) {
                for (int pk = 0; pk * pickerel <= totalPoint; pk++) {
                    int total = t * trout + p * pike + pk * pickerel;
                    if (total <= totalPoint && (t > 0 || p > 0 || pk > 0)) {
                        sb.append(t).append(" Brown Trout, ")
                          .append(p).append(" Northern Pike, ")
                          .append(pk).append(" Yellow Pickerel").append("\n");
                        way++;
                    }
                }
            }
        }

        sb.append("Number of ways to catch fish: ").append(way);

        bw.write(sb.toString());
        bw.flush();
    }
}

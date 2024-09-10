import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int p1 = 0;
            int p2 = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            p1 += getScore(getDistanceSquare(x1, y1));
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            p1 += getScore(getDistanceSquare(x2, y2));
            double x3 = Double.parseDouble(st.nextToken());
            double y3 = Double.parseDouble(st.nextToken());
            p1 += getScore(getDistanceSquare(x3, y3));
            double x4 = Double.parseDouble(st.nextToken());
            double y4 = Double.parseDouble(st.nextToken());
            p2 += getScore(getDistanceSquare(x4, y4));
            double x5 = Double.parseDouble(st.nextToken());
            double y5 = Double.parseDouble(st.nextToken());
            p2 += getScore(getDistanceSquare(x5, y5));
            double x6 = Double.parseDouble(st.nextToken());
            double y6 = Double.parseDouble(st.nextToken());
            p2 += getScore(getDistanceSquare(x6, y6));
            sb.append("SCORE: ").append(p1).append(" to ").append(p2).append(", ");
            sb.append(p1 == p2 ? "TIE." : p1 > p2 ? "PLAYER 1 WINS." : "PLAYER 2 WINS.").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static double getDistanceSquare(double x, double y) {
        return x * x + y * y;
    }

    static int getScore(double distanceSquare) {
        if (distanceSquare <= 9) return 100;
        else if (distanceSquare <= 36) return 80;
        else if (distanceSquare <= 81) return 60;
        else if (distanceSquare <= 144) return 40;
        else if (distanceSquare <= 225) return 20;
        return 0;
    }

}

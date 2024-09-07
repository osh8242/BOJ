import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        bw.write(getType(x1, y1, x2, y2, x3, y3));
        bw.flush();
    }

    static String getType(int x1, int y1, int x2, int y2, int x3, int y3) {
        if ((y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1)) return "X";
        int a = getLengthSquare(x1, y1, x2, y2);
        int b = getLengthSquare(x2, y2, x3, y3);
        int c = getLengthSquare(x3, y3, x1, y1);

        if (a == b && b == c) return "JungTriangle";

        int angleParam = Math.max(
                getAngleParam(a, b, c),
                Math.max(getAngleParam(b, c, a),
                        getAngleParam(c, a, b)));
        if (angleParam > 0) {
            return "Dunkak" + getTriangle(a, b, c);
        } else if (angleParam == 0) {
            return "Jikkak" + getTriangle(a, b, c);
        } else {
            return "Yeahkak" + getTriangle(a, b, c);
        }

    }

    static int getLengthSquare(int x1, int y1, int x2, int y2) {
        return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
    }

    static int getAngleParam(int a, int b, int c) {
        return c - a - b;
    }

    static String getTriangle(int a, int b, int c) {
        return ((a == b || b == c || c == a) ? "2" : "") + "Triangle";
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] records = new int[101];
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for (int j = start; j < end; j++) {
                records[j]++;
            }
        }

        int charge = 0;
        for (int i = 1; i <= 100; i++) {
            switch (records[i]) {
                case 1:
                    charge += A;
                    break;
                case 2:
                    charge += B * 2;
                    break;
                case 3:
                    charge += C * 3;
                    break;
                default:
                    break;
            }
        }
        System.out.println(charge);
    }


}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        line = new int[n];
        for (int i = 0; i < n; i++) line[i] = i;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int shift = Integer.parseInt(st.nextToken());
            if(shift == 0) continue;
            arrangement(i, shift);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(line[i]+1+" ");
        System.out.println(sb);
    }

    static void arrangement(int i, int shift) {
        int[] temp = new int[shift];
        for (int j = 0; j < shift; j++) {
            temp[j] = line[i-shift+j];
        }
        line[i-shift] = line[i];
        int index = 0;
        for(int j = i-shift+1  ; j <= i ; j++){
            line[j] = temp[index++];
        }
    }

}

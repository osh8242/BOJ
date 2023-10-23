import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if(M > 200000) {System.out.println(0); return;}
        int count = 0;
        boolean[] materials = new boolean[200001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int materialNumber = Integer.parseInt(st.nextToken());
            if(materialNumber >= M) continue;
            if(materials[M-materialNumber]) count++;
            else materials[materialNumber] = true;
        }
        System.out.println(count);
    }

}

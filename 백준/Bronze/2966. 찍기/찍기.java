import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final char[] Adrian = {'A','B','C'};
    static final char[] Bruno = {'B','A','B','C'};
    static final char[] Goran = {'C','C','A','A','B','B'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int adrian = 0;
        int bruno = 0;
        int goran = 0;
        for (int i = 0 ; i < N ; i++) {
            char ch = str.charAt(i);
            if(Adrian[i % Adrian.length] == ch) adrian++;
            if(Bruno[i % Bruno.length] == ch) bruno++;
            if(Goran[i % Goran.length] == ch) goran++;
        }

        int max = Math.max(adrian, Math.max(bruno, goran));
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        if(max == adrian) sb.append("Adrian").append("\n");
        if(max == bruno) sb.append("Bruno").append("\n");
        if(max == goran) sb.append("Goran").append("\n");
        System.out.println(sb);
    }
}
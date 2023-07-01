import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] spells = br.readLine().toCharArray();
        int[] count = new int[26];
        for(int i = 0 ; i < 26 ; i++) count[i] = 0;
        for(char ch : spells) count[ch-97]++;
        for(int i = 0 ; i < 26 ; i++) sb.append(count[i]+ " ");
        System.out.println(sb);

    }

}

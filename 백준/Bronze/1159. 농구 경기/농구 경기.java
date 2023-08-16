import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] record = new int[26];
        while(n-->0){
            record[br.readLine().charAt(0)-97]++;
        }
        int answer = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(record[i]>=5) {
                sb.append((char)(i+97));
                answer++;
            }
        }
        System.out.println(answer == 0 ? "PREDAJA" : sb.toString());

    }

}

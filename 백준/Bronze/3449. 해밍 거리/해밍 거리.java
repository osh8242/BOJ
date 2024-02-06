import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int answer = 0;
            char[] input1 = br.readLine().toCharArray();
            char[] input2 = br.readLine().toCharArray();
            for(int i = 0 ; i < input1.length ; i++){
                if(input1[i] != input2[i]) answer++;
            }
            sb.append("Hamming distance is ").append(answer).append(".\n");
        }
        System.out.println(sb);

    }

}
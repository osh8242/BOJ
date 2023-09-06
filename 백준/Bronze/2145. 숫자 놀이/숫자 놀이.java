import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = "";
        StringBuilder sb = new StringBuilder();
        while(!(num = br.readLine()).equals("0")){
            sb.append(makeSingleNum(num)).append("\n");
        }
        System.out.println(sb);

    }

    static int makeSingleNum(String num){
        int answer = Integer.parseInt(num);
        while(answer >= 10){
            num = String.valueOf(answer);
            char[] chars = num.toCharArray();
            answer = 0;
            for(char ch : chars){
                answer += ch-48;
            }
        }
        return answer;
    }

}

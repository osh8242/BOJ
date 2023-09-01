import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] count = new int[a+b+c+1];
        for(int i = 1 ; i <= a ; i++){
            for(int j = 1 ; j <= b ; j++){
                for(int k = 1 ; k <=c ; k++)
                    count[i+j+k]++;
            }
        }
        int answer = 0;
        for(int i = 3 ; i <= a+b+c ; i++){
            answer = count[answer] < count[i] ? i : answer;
        }
        System.out.println(answer);


    }
}

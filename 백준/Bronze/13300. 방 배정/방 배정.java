import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] countOfStudents = new int[7][2];
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            countOfStudents[y][g]++;
        }
        int answer = 0;
        for(int i =1 ; i <= 6 ; i++){
            for(int j = 0 ; j <=1 ; j++){
                int quotient = countOfStudents[i][j]/k;
                answer += countOfStudents[i][j]%k==0?quotient:quotient+1;
            }
        }
        System.out.println(answer);
    }

}

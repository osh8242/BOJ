import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] record = new int[n];
        record[0] = Integer.parseInt(br.readLine());
        for(int i = 2 ; i <= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] temp = record.clone();
            for(int order = 0 ; order < i ; order++){
                int num = Integer.parseInt(st.nextToken());
                if(order == 0) record[0] += num;
                else if (order == i-1) record[i-1] = num + temp[i-2];
                else record[order] = num + Math.max(temp[order], temp[order-1]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num : record){
            if(max < num) max = num;
        }
        System.out.println(max);

    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ArrayList<Integer> record = new ArrayList<>();
            record.add(a%10);
            int multiple = a%10;
            for(int i = 1 ; i < b ; i++){
                multiple = (multiple*(a%10))%10;
                if(multiple == record.get(0)) break;
                else record.add(multiple);
            }
            int cycle = record.size();
            int residue = b%cycle;
            int index;
            if(residue==0) index = record.size()-1;
            else index = residue-1;
            if(record.get(index) == 0) sb.append(10+"\n");
            else sb.append(record.get(index)+"\n");
        }
        System.out.println(sb);

    }

}

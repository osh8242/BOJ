import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> names = new HashSet<>();
        TreeSet<String> answer = new TreeSet<>();
        for (int i=0;i<n;i++){
            names.add(br.readLine());
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            String temp = br.readLine();
            if(!names.add(temp)){
                count++;
                answer.add(temp);
            }
        }
        sb.append(count+"\n");
        for(String str : answer){
            sb.append(str+"\n");
        }
        System.out.println(sb.toString());

    }

}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        count = 0;
        hanoi(1,3,n);
        System.out.println(count+"\n"+sb.toString());

    }
    static void hanoi(int start, int end, int height){
        if(height == 0) return;
        int mid = 6-start-end;
        hanoi(start,mid,height-1);
        sb.append(start+" "+end+"\n");
        count++;
        hanoi(mid,end,height-1);
    }

}

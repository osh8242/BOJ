import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean[] set = new boolean[21];
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            String[] command = br.readLine().split(" ");
            if(command[0].equals("add")){
                set[Integer.parseInt(command[1])] = true;
            } else if(command[0].equals("remove")){
                set[Integer.parseInt(command[1])] = false;
            } else if(command[0].equals("check")){
                if(set[Integer.parseInt(command[1])]) sb.append("1\n");
                else sb.append("0\n");
            } else if(command[0].equals("toggle")){
                set[Integer.parseInt(command[1])] = !set[Integer.parseInt(command[1])];
            } else if(command[0].equals("all")){
                for(int j = 1 ; j <= 20 ; j++){
                    set[j] = true;
                }
            } else if(command[0].equals("empty")){
                for(int j = 1 ; j <= 20 ; j++){
                    set[j] = false;
                }
            }

        }
        System.out.println(sb.toString());

    }

}
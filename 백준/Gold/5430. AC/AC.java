import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
outer : for (int test = 1 ; test <= t ; test++){
            String command = br.readLine().replaceAll("RR","");
            int count = Integer.parseInt(br.readLine());
            Deque<Integer> nums = new ArrayDeque<>();
            String[] temp = br.readLine().replace("[","").replace("]","").split(",");
            for (int i = 0 ; i < count ; i++){
                nums.add(Integer.parseInt(temp[i]));
            }
            boolean isReverse = false;
            for(int i = 0 ; i < command.length() ; i++){
                switch (command.charAt(i)){
                    case 'R':
                        isReverse = !isReverse; break;
                    case 'D':
                        if(nums.size() == 0) {
                            sb.append("error\n");
                            continue outer;
                        }
                        if(!isReverse) nums.removeFirst();
                        else nums.removeLast();
                }
            }

            if(!isReverse) sb.append(nums.toString().replaceAll(" ","")+"\n");
            else{
                ArrayList<Integer> rNums = new ArrayList<>();
                while(nums.size()>0){
                    rNums.add(nums.removeLast());
                }
                sb.append(rNums.toString().replaceAll(" ","")+"\n");
            }
        }
        System.out.println(sb.toString());

    }
}

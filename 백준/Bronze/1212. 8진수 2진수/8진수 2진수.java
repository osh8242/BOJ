import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static final String[] code = {"000","001","010","011","100","101","110","111"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] nums = br.readLine().toCharArray();
        for(int i = 0 ; i < nums.length ; i++){
            sb.append(code[Character.getNumericValue(nums[i])]);
        }
        int index = sb.toString().indexOf('1');
        if(index == -1) System.out.println(0);
        else System.out.println(sb.toString().substring(index));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0 ; i < arr.length ; i++){
            stack.add(arr[i]);
            if(stack.size() >= boom.length){
                boolean isEqual = true;
                for(int j = 0 ; j < boom.length ; j++){
                    if(stack.get(stack.size()-1-j) != boom[boom.length-1-j]){
                        isEqual = false;
                        break;
                    }
                }
                if(isEqual){
                    for (int j = 0 ; j < boom.length ; j++){
                        stack.remove(stack.size()-1);
                    }
                }
            }
        }
        if(stack.size() == 0){
            System.out.println("FRULA");
        } else{
            StringBuilder sb = new StringBuilder();
            for(Character ch : stack){
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }

    }

}

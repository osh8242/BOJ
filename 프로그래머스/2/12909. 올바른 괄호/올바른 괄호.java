import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Boolean> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            switch(ch){
                case '(' :
                    stack.push(true);
                    break;
                case ')' :
                    if(stack.isEmpty()) return false;
                    else stack.pop();                    
            }
        }
        return stack.isEmpty();
    }
}
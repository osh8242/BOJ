import java.util.ArrayList;

class Solution {
    public String[] solution(String myStr) {
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : myStr.toCharArray()) {
            if(ch == 'a' || ch == 'b' || ch == 'c') {
                if(!sb.isEmpty()) list.add(sb.toString());
                sb = new StringBuilder();
            } else sb.append(ch);
        }
        if(!sb.isEmpty()) list.add(sb.toString());
        if(list.isEmpty()) return new String[] {"EMPTY"};
        return list.stream()
            .toArray(String[]::new);
    }
}
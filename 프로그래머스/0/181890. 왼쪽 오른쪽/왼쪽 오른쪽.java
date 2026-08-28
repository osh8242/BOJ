import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] str_list) {
        for(int i = 0 ; i < str_list.length ; i++) {
            String str = str_list[i];
            if(str.equals("u") || str.equals("d")) continue;
            if(str.equals("l"))
                return IntStream.range(0, i)
                    .mapToObj(idx -> str_list[idx])
                    .toArray(String[]::new);
            if(str.equals("r"))
                return IntStream.range(i+1, str_list.length)
                    .mapToObj(idx -> str_list[idx])
                    .toArray(String[]::new);
        }        
        return new String[0];
    }
}
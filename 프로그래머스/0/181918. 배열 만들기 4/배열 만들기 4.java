import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr) {        
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        for(int i = 0 ; i < n ; i++) {
            if (list.size() == 0) list.add(arr[i]);                            
            else if(list.get(list.size() - 1) < arr[i]) list.add(arr[i]);
            else {
                list.remove(list.size() - 1); i--;                        
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
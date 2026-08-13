import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 1;
        int[] records = new int[7];
        records[a]++;
        records[b]++;
        records[c]++;
        records[d]++;
        List<Record> list = new ArrayList<>();
        for(int i = 1; i < records.length; i++) {
            if(records[i] == 0) continue;
            list.add(new Record(i, records[i]));
        }
        if(list.size() == 1) return list.get(0).getValue()*1111;
        if(list.size() == 2) {
            Record r = list.get(0);
            int count = r.getCount();
            if(count == 2) {
                int p= list.get(0).getValue(); int q= list.get(1).getValue();
                return (p+q)*(q-p);                
            }
            if(count == 1) return (10 * list.get(1).getValue() + r.getValue()) * (10 * list.get(1).getValue() + r.getValue());
            if(count == 3) return (10 * r.getValue() + list.get(1).getValue()) * (10 * r.getValue() + list.get(1).getValue());
            
        }
        if(list.size() == 3) {
            for(Record r : list) {
                if(r.getCount() != 2) answer *= r.getValue();
            }
            return answer;
        }
        if(list.size() == 4) {
            return list.get(0).getValue();
        }
        return answer;
    }
    
    public static class Record {
        int value;
        int count;
        
        Record (int value, int count) {
            this.value = value;
            this.count = count;
        }
        
        private int getValue() {
            return this.value;
        }
        
        private int getCount() {
            return this.count;
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        AbsHeap absHeap = new AbsHeap();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++){
            int command = Integer.parseInt(br.readLine());
            if(command == 0){
                sb.append(absHeap.poll()+"\n");
            } else{
                absHeap.insert(command);
            }
        }
        System.out.println(sb.toString());
    }
}

class AbsHeap {

    private ArrayList<Integer> absHeap;

    public AbsHeap(){
        absHeap = new ArrayList<>();
        absHeap.add(0);
    }

    public void insert(int val){
        absHeap.add(val);
        int index = absHeap.size()-1;
        while(index > 1 &&
                (Math.abs(absHeap.get(index/2)) > Math.abs(val)
                || (Math.abs(absHeap.get(index/2)) == Math.abs(val)) && absHeap.get(index/2) > val)){
                absHeap.set(index, absHeap.get(index/2));
                absHeap.set(index/2, val);
                index /= 2;
        }
    }

    public int poll(){
        if(absHeap.size() == 1) return 0;
        int answer = absHeap.get(1);
        absHeap.set(1, absHeap.get(absHeap.size()-1));
        absHeap.remove(absHeap.size()-1);
        int index = 1;
        while(2*index < absHeap.size()){
            int childVal = absHeap.get(2*index);
            int childIndex = 2*index;
            if(2*index+1 < absHeap.size()){
                if(Math.abs(childVal) > Math.abs(absHeap.get(2*index+1))
                    || (Math.abs(childVal) == Math.abs(absHeap.get(2*index+1))
                    && childVal > absHeap.get(2*index+1))) {
                    childVal = absHeap.get(2 * index + 1);
                    childIndex = 2 * index + 1;
                }
            }

            if(Math.abs(childVal) > Math.abs(absHeap.get(index))
                || (Math.abs(childVal) == Math.abs(absHeap.get(index))
                && childVal > absHeap.get(index))) break;
            absHeap.set(childIndex, absHeap.get(index));
            absHeap.set(index, childVal);
            index = childIndex;
        }
        return answer;
    }

}

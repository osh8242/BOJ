import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        MaxHeap heap = new MaxHeap();
        int n = Integer.parseInt(br.readLine());
        for(int test = 1 ; test <= n ; test++){
            int command = Integer.parseInt(br.readLine());
            if(command==0){
                sb.append(heap.poll()+"\n");
            } else {
                heap.insert(command);
            }
        }
        System.out.println(sb.toString());
    }

}

class MaxHeap {
    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
        heap.add(0);
    }

    public void insert(int num) {
        heap.add(num);
        int i = heap.size() - 1;
        while (i > 1 && heap.get(i / 2) < num) {
            heap.set(i, heap.get(i / 2));
            heap.set(i / 2, num);
            i /= 2;
        }
    }

    public int poll() {
        if(heap.size()==1) return 0;
        int max = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int i = 1;
        while(2*i < heap.size()){
            int cVal = heap.get(2*i);
            int cIndex = 2*i;
            if(2*i+1 < heap.size() && heap.get(2*i+1) > cVal){
                cVal = heap.get(2*i+1);
                cIndex = 2*i+1;
            }
            if(heap.get(i) >= cVal) break;
            heap.set(cIndex, heap.get(i));
            heap.set(i, cVal);
            i = cIndex;
        }
        return max;
    }
}
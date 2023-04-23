import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Heap heap = new Heap();
        int n = Integer.parseInt(br.readLine());
        for( int test = 1 ; test <= n ; test++){
            int command = Integer.parseInt(br.readLine());
            if(command == 0) sb.append(heap.delete()+"\n");
            else heap.insert(command);
        }
        System.out.println(sb.toString());
    }
}

class Heap{
    public ArrayList<Integer> heap;
    public Heap(){
        heap = new ArrayList<>();
        heap.add(0);
    }
    public void insert(int value){
        heap.add(value);
        int index = heap.size()-1;
        while(index>1 && value < heap.get(index/2)){
            int pValue = heap.get(index/2);
            heap.set(index/2, heap.get(index));
            heap.set(index, pValue);
            index /= 2;
        }
    }

    public int delete(){
        if(heap.size() == 1) return 0;
        int deleted_value = heap.get(1);
        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int index = 1;
        while(2*index < heap.size()){
            int childValue = heap.get(2*index);
            int childIndex = 2*index;
            if(2*index+1<heap.size() && childValue > heap.get(2*index+1)){
                childValue = heap.get(2*index+1);
                childIndex = 2*index+1;
            }
            if(heap.get(index) <= childValue) break;
            heap.set(childIndex, heap.get(index));
            heap.set(index, childValue);
            index = childIndex;
        }
        return deleted_value;
    }
}
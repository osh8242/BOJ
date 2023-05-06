import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main{
    static class Num{
        int val; // 숫자값
        int maxIndex; // 최대힙에서의 인덱스
        int minIndex; // 최소힙에서의 인덱스
        Num(int val){
            this.val = val;
            maxIndex = -1;
            minIndex = -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        DualHeap dh = new DualHeap(); // 이중우선큐 dh
        for(int test = 1 ; test <= T ; test++){
            int lines = Integer.parseInt(br.readLine());
            for(int line = 1 ; line <= lines ; line++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int command = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                switch (command){
                    case 'I' : dh.insert(num); break; // insert() 호출
                    case 'D' : {
                        switch (num){
                            case 1 : {
                                if(dh.maxHeap.size() > 1) dh.deleteMax(); break; // 값이 있으면 deleteMax() 호출
                            }
                            case -1 : {
                                if(dh.minHeap.size() > 1) dh.deleteMin(); break; // 값이 있으면 deleteMin() 호출
                            }
                        }
                    } break;
                }
            }
            if(dh.maxHeap.size() == 1) sb.append("EMPTY\n"); // 값이 없으면 EMPTY 출력
            else sb.append(dh.maxHeap.get(1).val + " " + dh.minHeap.get(1).val+"\n"); //값이 있으면 최대, 최소 출력

        }
        System.out.println(sb.toString());
    } // void main()

    public static class DualHeap{
        ArrayList<Num> maxHeap;
        ArrayList<Num> minHeap;
        DualHeap(){
            maxHeap = new ArrayList<>(); // 최대힙 ArrayList
            maxHeap.add(null); // 인덱스를 1부터 쓰기위해 null 하나 넣어놓기
            minHeap = new ArrayList<>(); // 최소힙 ArrayList
            minHeap.add(null); // 인덱스를 1부터 쓰기 위해 null 하나 넣어놓기
        } // constructor

        public void insert(int val){
            Num num = new Num(val); // val 값을 가지는 Num 클래스 생성
            maxHeap.add(num); // 최대힙에 추가
            minHeap.add(num); // 최소힙에 추가

            //최대힙부터 삽입시 정렬하기
            int i = maxHeap.size()-1; // 탐색시작위치 = 최대힙 마지막 위치
            while(i > 1 && num.val > maxHeap.get(i/2).val){ // 신규 num과 부모의 위치를 바꿔야한다면, 반복
                maxHeap.get(i/2).maxIndex = i; // 부모 Num의 인덱스 i/2를 자식 인덱스 i로 바꿈
                maxHeap.set(i, maxHeap.get(i/2)); // 자식 위치에 부모 Num을 대입
                maxHeap.set(i/2, num); // 부모 위치에 자식이었던 신규 num을 대입
                i /= 2; // 탐색 위치를 부모 위치로 바꾸기
            }
            num.maxIndex = i; // 신규 num의 maxHeap 인덱스 기록

            //최소힙에서 삽입시 정렬하기
            i = minHeap.size()-1; // 탐색시작위치 = 최소힙의 마지막 위치
            while(i > 1 && num.val < minHeap.get(i/2).val){ // 신규 num과 부모의 위치를 바꿔야한다면, 반복
                minHeap.get(i/2).minIndex = i; // 부모 Num의 인덱스 i/2를 자식 인덱스 i로 바꿈
                minHeap.set(i, minHeap.get(i/2)); // 자식 위치에 부모 Num을 대입
                minHeap.set(i/2, num); // 부모 위치에 자식이었던 신규 num을 대입
                i /= 2; // 탐색 위치를 부모 위치로 바꾸기
            }
            num.minIndex = i; // 신규 num의 minHeap 인덱스 기록
        } // void insert()

        public int deleteMin(){
            Num minNum = minHeap.get(1); // minHeap의 첫번째 Num 가져오기
            int min = minNum.val; // 첫번째 Num의 val이 최소값
            minHeap.set(1, minHeap.get(minHeap.size()-1)); // minHeap의 가장 마지막 Num을 인덱스 1에 덮어쓰기
            minHeap.get(1).minIndex = 1; // 덮어쓴 Num의 minIndex를 1로 수정
            minHeap.remove(minHeap.size()-1); // 가장 마지막 Num 제거
            minHeapSort(1); // 인덱스 1부터 minHeap 정렬하기

            int i = minNum.maxIndex; // minHeap에서 제거한 값의 maxHead 인덱스
            maxHeap.set(i, maxHeap.get(maxHeap.size()-1)); // minHeap에서 제거된 값의 maxHeap 위치의 Num을 가장 마지막 Num으로 덮어씀
            maxHeap.get(i).maxIndex = i; // 덮어쓴 Num의 maxHeap 인덱스 갱신
            maxHeap.remove(maxHeap.size()-1); // 가장 마지막 Num 제거
            maxHeapSort(i); // 덮어쓴 위치에서부터 maxHeap 정렬하기

            return min; // 최소값 반환
        } // int deleteMin()

        public int deleteMax(){
            Num maxNum = maxHeap.get(1); // maxHeap의 첫번째 Num 가져오기
            int max = maxNum.val; // 첫번째 Num의 val이 최대값
            maxHeap.set(1, maxHeap.get(maxHeap.size()-1)); // maxHeap의 가장 마지막 Num을 첫번째 위치로 가져오기
            maxHeap.get(1).maxIndex = 1; // 첫번째로 가져온 Num의 인덱스 갱신
            maxHeap.remove(maxHeap.size()-1); // 가장 마지막 Num 제거
            maxHeapSort(1); // 인덱스 1부터 maxHeap 정렬하기

            int i = maxNum.minIndex; // 최대값이었던 Num의 minHeap 인덱스
            minHeap.set(i, minHeap.get(minHeap.size()-1)); // minIndex 위치에 minHeap의 가장 마지막 Num 덮어쓰기
            minHeap.get(i).minIndex = i; // 덮어쓴 Num의 인덱스 갱신
            minHeap.remove(minHeap.size()-1); // 가장 마지막 Num 제거
            minHeapSort(i); // 덮어쓴 위치에서부터 minHeap 정렬하기

            return max; // 최대값 반환
        } // int deleteMax()

        void maxHeapSort(int i){
            while(2*i < maxHeap.size()){ // 왼쪽 자식 노드가 존재한다면
                Num cNum = maxHeap.get(2*i); // 왼쪽 자식노드 Num과 인덱스값 기록
                int cIndex = 2*i;
                if(2*i+1 < maxHeap.size() && cNum.val < maxHeap.get(2*i+1).val){ //오른쪽 자식노드가 있고, 왼쪽 자식노드가 val보다 크다면
                    cNum = maxHeap.get(2*i+1); // 왼쪽 자식노드 기록값을 오른쪽 자식노드 값으로 변경
                    cIndex = 2*i+1;
                }
                if(cNum.val <= maxHeap.get(i).val) break; // 부모의 val이 자식의 val보다 같거나 크면 바꿀 필요가 없으므로 break;
                maxHeap.get(i).maxIndex = cIndex; // 부모노드의 인덱스를 자식인덱스로 바꿈
                maxHeap.set(cIndex, maxHeap.get(i)); // 자식노드 위치에 부모노드 삽입
                cNum.maxIndex = i; // 자식노드의 인덱스를 부모인덱스로 바꿈
                maxHeap.set(i, cNum); // 부모노드 위치에 자식노드 삽입
                i = cIndex; // 탐색위치를 자식노드로 변경
            }
        } // void maxHeapSort()

        void minHeapSort(int i){
            while(2*i < minHeap.size()){ // 왼쪽 자식노드가 있다면
                Num cNum = minHeap.get(2*i); // 왼쪽 자식노드 Num과 인덱스 값 기록
                int cIndex = 2*i;
                if(2*i+1 < minHeap.size() && cNum.val > minHeap.get(2*i+1).val){ // 오른쪽 자식노드가 있고, 왼쪽 자식노드 val보다 작으면
                    cNum = minHeap.get(2*i+1); // 왼쪽 자식노드, 인덱스 기록값을 오른쪽 자식노드, 인덱스 값으로 바꿈
                    cIndex = 2*i+1;
                }
                if(cNum.val >= minHeap.get(i).val) break; // 자식 노드 val보다 부모 노드 val이 같거나 작으면 break;
                minHeap.get(i).minIndex = cIndex; // 부모노드의 인덱스를 자식인덱스로 바꿈
                minHeap.set(cIndex, minHeap.get(i)); // 자식노드에 부모노드 삽입
                cNum.minIndex = i; // 자식노드의 인덱스를 부모인덱스로 바꿈
                minHeap.set(i, cNum); // 부모노드에 자식노드 삽입
                i = cIndex; // 탐색위치를 자식노드로 변경
            }
        } // void minHeapSort()
    } // Class DualHeap
} //Class Main
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static class Person{
        int index;
        boolean knowTrue;

        public Person(int index) {
            this.index = index;
            this.knowTrue = false;
        }

        public int getIndex() {
            return index;
        }

        public boolean isKnowTrue() {
            return knowTrue;
        }

        public void setKnowTrue(boolean knowTrue) {
            this.knowTrue = knowTrue;
        }
    }

    static int n, m;

    static boolean[][] connections;

    static Queue<Person> trueQue = new LinkedList<>();
    static boolean[] isVisitedParty;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Person[] persons = new Person[n+1];
        for(int i = 1 ; i <= n ; i++){
            persons[i] = new Person(i);
        }
        st = new StringTokenizer(br.readLine());
        int truePersonNum = Integer.parseInt(st.nextToken());
        while (truePersonNum-- > 0){
            int index = Integer.parseInt(st.nextToken());
            persons[index].setKnowTrue(true);
            trueQue.add(persons[index]);
        }
        connections = new boolean[m+1][n+1];
        for(int i = 1 ; i <= m ; i++){
            st = new StringTokenizer(br.readLine());
            int partyCapacity = Integer.parseInt(st.nextToken());
            while(partyCapacity-->0){
                int index = Integer.parseInt(st.nextToken());
                connections[i][index] = true;
            }
        }
        isVisitedParty = new boolean[m+1];
        while(!trueQue.isEmpty()){
            Person person = trueQue.poll();
            int index = person.getIndex();
            for(int i = 1 ; i <= m ; i++){
                if(connections[i][index] && !isVisitedParty[i]) {
                    isVisitedParty[i] = true;
                    for(int j = 1 ; j <= n ; j++){
                        if(connections[i][j] && !persons[j].isKnowTrue()){
                            persons[j].setKnowTrue(true);
                            trueQue.add(persons[j]);
                        }
                    }
                }
            }
        }
        int answer = 0;
        for(int i = 1 ; i <= m ; i++){
            if(!isVisitedParty[i]) answer++;
        }
        System.out.println(answer);
    }
}

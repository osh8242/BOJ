import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {        
        int length = genres.length;
        // 장르별로 총 재생시간을 저장할 장르맵
        HashMap<String, Integer> genrePlayTimeMap = new HashMap<>();
        // 장르별로 노래들을 저장할 노래맵
        HashMap<String, PriorityQueue<Song>> songs = new HashMap<>();
        for(int i = 0 ; i < length ; i++){
            String genre = genres[i];
            int playTime = plays[i];
            // 장르맵에 총 재생횟수 갱신
            genrePlayTimeMap.put(genre, genrePlayTimeMap.getOrDefault(genre,0) + playTime);
            // 노래맵에 노래저장
            if(!songs.containsKey(genre)) songs.put(genre, new PriorityQueue<>());
            songs.get(genre).add(new Song(i, playTime));
        }
        // 우선순위큐를 이용하여 장르를 저장(리스트 정렬로 대체가능)
        PriorityQueue<Genre> pq = new PriorityQueue<>();
        for(String genre : genrePlayTimeMap.keySet()){
            pq.add(new Genre(genre, genrePlayTimeMap.get(genre)));
        }
        // 정답출력용 ArrayList
        List<Integer> list = new ArrayList<>();
        
        while(!pq.isEmpty()){
            // 총 재생횟수가 높은 장르부터 하나씩 추출
            Genre tempGenre = pq.poll();
            String genre = tempGenre.genre;
            int totalPlayTime = tempGenre.totalPlayTime;
            
            PriorityQueue<Song> songList = songs.get(genre);
            // 각 장르 별로 최대 2곡까지만 선택
            for(int i = 0 ; i < 2 && !songList.isEmpty() ; i++){
                Song song = songList.poll();
                list.add(song.index);
            }           
        }
        // ArrayList에서 정답용 배열로 변환
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }        
        return answer;
    }
    
    // 노래 객체 (고유번호, 재생횟수)
    private class Song implements Comparable<Song>{
        private int index;
        private int playTime;
        public Song (int index, int playTime){
            this.index = index;
            this.playTime = playTime;
        }
        
        //오름차순(재생횟수) -> 내림차순(고유번호)
        @Override
        public int compareTo(Song other){
            return this.playTime < other.playTime ? 1 : 
            this.playTime == other.playTime ? this.index-other.index : -1;
        }
    }
    
    // 장르객체(장르명, 총재생횟수)
    private class Genre implements Comparable<Genre>{
        private String genre;
        private int totalPlayTime;
        public Genre (String genre, int totalPlayTime){
            this.genre = genre;
            this.totalPlayTime = totalPlayTime;
        }        
        
        //내림차순(총재생횟수)
        @Override
        public int compareTo(Genre other){
            return other.totalPlayTime - this.totalPlayTime;
        }
    }
}
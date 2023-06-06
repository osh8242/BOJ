import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] picks, String[] minerals) { //메인 실행함수
        int[] determinePicksArray = determinePicksArray(picks, minerals); //사용할 곡괭이 배열[]
		int totalPicksNum = totalPicksNum(determinePicksArray); //사용할 곡괭히 개수
        String[][] splitMinerals = splitMinerals(totalPicksNum, minerals); // minerals 배열을 5개씩 끊은 2차배열 splitMinerals
        int[][] FatigueArray = FatigueArray(splitMinerals); // 2차배열 splitMinerals의 각 요소마다 피로도 계산
        return sumFatigue(FatigueArray, determinePicksArray); // 사용할 곡괭이 배열을 가지고 최소피로도 계산
    }
    
    // 곡괭이 배열에서 총 곡괭이 갯수 반환함수
    public int totalPicksNum (int[] picks) { 
		return picks[0]+picks[1]+picks[2];
	}
    
	// 모든 광물을 캐기위한 곡괭이 갯수 반환함수
	public int determineNumsOfPicksNeed(String[] minerals) {
		return (minerals.length%5==0)? (minerals.length/5) : ((minerals.length/5)+1);
	}
	
    // 사용할 곡괭이 배열[다이아곡괭이, 철곡괭이, 돌곡괭이]
	public int[] determinePicksArray(int[] picks, String[] minerals) {
		int[] answer = new int[3];		
		if (determineNumsOfPicksNeed(minerals)>= totalPicksNum(picks)) {
			return picks;
		} else {
			int determineNumsOfPicksNeed = determineNumsOfPicksNeed(minerals);
			for (int i = 0 ; i <picks.length ; i++) {
				while(picks[i]>0 && determineNumsOfPicksNeed>0) {
					answer[i]++;
					picks[i]--;
					determineNumsOfPicksNeed--;
				}
			}
		}
		
		return answer;
	}
	
    // 사용할 곡괭이 갯수와 광물 배열을 통해서 실제로 캘만큼만 5개단위로 쪼개어 String[][]로 반환하는 함수
	public String[][] splitMinerals (int totalPicksNum, String[] minerals){
		String[][] answer = new String[totalPicksNum][];
		int indexOfMinerals = 0;
		int indexOfAnswer = 0;
		while(totalPicksNum>1) {			
			answer[indexOfAnswer] = Arrays.copyOfRange(minerals, indexOfMinerals, indexOfMinerals+5);
			totalPicksNum--;
			indexOfAnswer++;
			indexOfMinerals += 5;
		}
		answer[indexOfAnswer] = Arrays.copyOfRange(minerals, indexOfMinerals, Math.min(minerals.length,indexOfMinerals+5));
		
		return answer;
	}
	
    // 광물배열을 받아 광물 종류별 갯수 배열 countMinerals로 반환 [다이아, 철, 돌]
	public int[] countMinerals(String[] mineralsSubarray) {
		int[] answer = new int[3];
		for (int i = 0; i<mineralsSubarray.length ; i++) {
			if (mineralsSubarray[i].equals("diamond")) {
				answer[0]++; continue;
			} else if (mineralsSubarray[i].equals("iron")) {
				answer[1]++; continue;
			} else {
				answer[2]++;
			}
		}		
		return answer;
	}
	
    // 광물 갯수가 담긴 countMinerals에서 각 곡괭이마다 쌓이는 피로도 계산 후 반환 [다이아 곡괭이 피로도, 철 곡괭이 피로도, 돌 곡괭이 피로도]
	public int[] calculateFatigue(int[] countMinerals) {
		int[] answer = {0,0,0};
		for (int i = 0 ; i < answer.length; i++) {
			for (int j = 0 ; j < countMinerals.length; j++) {
				if ((i-j)<=0) {
					answer[i] += countMinerals[j];
				} else if ((i-j)==1){
					answer[i] += countMinerals[j]*5;
				} else if ((i-j)==2){
					answer[i] += countMinerals[j]*25;
				}				
			}
		}
		return answer;
	}
    
	// 쪼개진 광물 배열 splitMinerals을 받아서 곡괭이별로 드는 피로도 계산
	public int[][] FatigueArray(String[][] splitMinerals){		
		int[][] answer = new int[splitMinerals.length][3];
		for (int i = 0 ; i < answer.length ; i++) {
			answer[i] = calculateFatigue(countMinerals(splitMinerals[i]));
		}		
		return answer;
	}
	
    // 사용할 곡괭이 배열 determinePicksArray와 피로도 계산 배열 FatigueArray을 가지고 최소피로도 계산
	public int sumFatigue(int[][] FatigueArray, int[] determinePicksArray) {
		int answer=0;
		Map<Integer, int[]> map = new HashMap<Integer, int[]>();
		for (int i = 0 ; i < FatigueArray.length ; i++) {
			map.put(i, FatigueArray[i]);
		}		
		for (int j = determinePicksArray.length-1 ; j>=0 ; j--){
			
			while(determinePicksArray[j]>0) {
				int min = 126;
				int check = 0;
				for (Integer key : map.keySet()) {					
					if (min > map.get(key)[j]) {
						min = map.get(key)[j];
						check = key;						
					}
				}	
				answer += map.get(check)[j];
				determinePicksArray[j]--;
				map.remove(check);					 
			}
			determinePicksArray[j]--;
		}	
		return answer;
	}
    
    
}
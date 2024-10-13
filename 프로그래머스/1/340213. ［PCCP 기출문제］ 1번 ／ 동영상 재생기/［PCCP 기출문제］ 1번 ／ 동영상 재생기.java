import java.util.StringTokenizer;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int totalSeconds = parseSeconds(video_len);
        int opStartSecond = parseSeconds(op_start);
        int opEndSecond = parseSeconds(op_end);
        int current = parseSeconds(pos);
        if(inOpening(current, opStartSecond, opEndSecond)) current = opEndSecond;
        
        for (String command : commands) {
            switch(command) {
                case "prev" : {
                    current = checkLeftBoundary(current) ? 0 : current - 10;
                    break;
                }
                case "next" : {
                    current = checkRightBoundary(current, totalSeconds) ? totalSeconds : current + 10;
                    break;
                }
            }
            if(inOpening(current, opStartSecond, opEndSecond)) current = opEndSecond;
        }
        
        return getTime(current);
    }
               
    String getTime(int current) {
        return String.format("%02d:%02d", current / 60, current % 60);
    }
    
    boolean inOpening(int current, int start, int end) {
        return start <= current && current <= end;
    }
    
    int parseSeconds(String video_len) {
        StringTokenizer st = new StringTokenizer(video_len, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
    
    boolean checkLeftBoundary(int current) {
        return current < 10;
    }
    
    boolean checkRightBoundary(int current, int totalSeconds) {
        return current + 10 > totalSeconds;
    }
}
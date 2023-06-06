class Solution {
    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int test_case = 0 ; test_case < balls.length; test_case++ ) {
        	if ( startX == balls[test_case][0]) {
        		int h = Math.min(balls[test_case][0]+startX, m-startX+m-balls[test_case][0]);
        		int v = Math.abs(startY - balls[test_case][1]);
        		
        		if ( startY < balls[test_case][1]) {
        			int y0 = startY+balls[test_case][1];
        			answer[test_case] = Math.min((h*h + v*v), y0*y0);
            		continue;
        		}
        		
        		if ( startY > balls[test_case][1]) {
        			int yn = n- startY + n - balls[test_case][1];
        			answer[test_case] = Math.min((h*h + v*v), yn*yn);
            		continue;
        		}
        		
        		
        		} else if ( startY == balls[test_case][1]) {
        			int h = Math.abs(startX - balls[test_case][0]);
        			int v = Math.min(balls[test_case][1]+startY, n-startY+n-balls[test_case][1]);
        			
        			if ( startX < balls[test_case][0]) {
        				int x0 = startX + balls[test_case][0];
            			answer[test_case] = Math.min((h*h + v*v), x0*x0);
                		continue;
            		}
            		
            		if ( startX > balls[test_case][0]) {
            			int xm = m-startX + m-balls[test_case][0];
            			answer[test_case] = Math.min((h*h + v*v), xm*xm);
                		continue;
            		}
            		
        		} else {
        			double x0 = (Math.pow(balls[test_case][0]+startX, 2) + Math.pow(Math.abs(startY-balls[test_case][1]), 2));
        			double xm = (Math.pow(m-balls[test_case][0]+m-startX, 2) + Math.pow(Math.abs(startY-balls[test_case][1]), 2));
        			double y0 = (Math.pow(Math.abs(startX-balls[test_case][0]), 2) + Math.pow(balls[test_case][1]+startY, 2));
        			double yn = (Math.pow(n-balls[test_case][1]+n-startY, 2) + Math.pow(Math.abs(startX-balls[test_case][0]), 2));
        			answer[test_case] = (int) Math.min(Math.min(y0, yn), Math.min(x0, xm));
        		}
        }
        return answer;
    }
}
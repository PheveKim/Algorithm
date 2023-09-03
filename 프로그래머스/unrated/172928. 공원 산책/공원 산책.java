import java.util.*;
class Solution {
    static int R;
    static int C;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        R = park.length;
        C = park[0].length();
        
        int cur_row = 0, cur_col = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(park[r].charAt(c) == 'S'){
                    cur_row = r;
                    cur_col = c;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            
            StringTokenizer st = new StringTokenizer(routes[i], " ");
            
            String direction = st.nextToken();
            int degree = Integer.parseInt(st.nextToken());
            
            int idx = 0, cnt = 1;
            int nr, nc;
            if(direction.equals("E")){
                idx = 3;
            }
            else if(direction.equals("W")){
                idx = 2;
            }
            else if(direction.equals("S")){
                idx = 1;
            }
            else{
                idx = 0;
            }
            while(true){
                nr = cur_row + dr[idx] * cnt;
                nc = cur_col + dc[idx] * cnt;
                if(bc(nr,nc) == false) break;
                if(park[nr].charAt(nc) == 'X') {
                    break;
                }
                cnt++;
                if(degree == cnt - 1) {
                    cur_row = nr;
                    cur_col = nc;
                    break;
                }
            }
        }
        return new int[] {cur_row, cur_col};
    }
    
    public boolean bc(int row, int col){
        if(row<0 || row>=R || col<0 || col>=C) return false;
        return true;
    }
}
import java.util.*;
class Solution {
    public int solution(String s) {
        
        int cnt = 0;
        Loop1: while(true){
            if(s.length() == 0) break;
            if(s.length() == 1) {
                cnt++;
                break;
            }
            char c = s.charAt(0);
            int same_cnt = 1;
            int diff_cnt = 0;
            
            for(int i=1; i<s.length(); i++){
        
                char d = s.charAt(i);
                if(c==d) same_cnt++;
                else diff_cnt++;
                
                if(same_cnt == diff_cnt){
                    cnt++;
                    s = s.substring(i+1,s.length());
                    continue Loop1;
                }
            }
            cnt++;
            break;
        }
        return cnt;
    }
}
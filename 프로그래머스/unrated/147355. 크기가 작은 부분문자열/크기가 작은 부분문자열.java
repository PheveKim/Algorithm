import java.util.*;
import java.io.*;

class Solution {
    public int solution(String t, String p) {
        int p_len = p.length();
        Long p_int = Long.parseLong(p);
        int cnt = 0;
        for(int i=0; i<t.length()-p_len+1; i++){
            
            String target = t.substring(i,i+p_len);
            Long target_int = Long.parseLong(target);
            if(target_int <= p_int){
                cnt++;
            }
        
        }
        
        
        
        
        
        return cnt;
    }
}
import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int p_len = p.length();
        long pi = Long.parseLong(p);
        
        for(int i=0; i<t.length(); i++) {
            if(i == t.length() - p_len + 1) break;
            String s = t.substring(i, i+p_len);
            Long si = Long.parseLong(s);
            
            if(si <= pi) answer++;
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] s = {"aya", "ye", "woo", "ma"};
        int cnt = 0;
        for(int i=0; i<babbling.length; i++){
            String test = babbling[i];
            boolean complete = false;
            Loop1: while(true){
                boolean has = false;
                for(int j=0; j<s.length; j++){
                    String target = s[j];
                    if(target.length() > test.length()) continue;
                    String test_part = test.substring(0, target.length());
                    if(target.equals(test_part)){
                        has = true;
                        test = test.substring(target.length(), test.length());
                        if(test.length() == 0) {
                            complete = true;
                            break;
                        }
                        continue Loop1;
                    }
                }
                if(!has) break;
            }
            if(complete) cnt++;
        }
        
        
        return cnt;
    }
}
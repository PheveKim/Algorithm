import java.util.Arrays;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] chars = s.toCharArray();
        
        for(int i=0; i<chars.length; i++){
        
            for(int j=0; j<i+1; j++){
                    
                if(chars[i] == chars[i-j] && j != 0) {
                    answer[i] = j;
                    break;
                }
                else answer[i] = -1;
            }
            
        }
        
        
        return answer;
    }
}
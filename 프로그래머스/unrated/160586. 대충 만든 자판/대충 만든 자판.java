import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                char c = keymap[i].charAt(j);
                if(map.get(c) == null){
                    map.put(c, j+1);
                }
                else if(map.get(c) > j){
                    map.put(c, j+1);
                }
            }
        }
        
        int[] result = new int[targets.length];
        for(int i=0; i<targets.length; i++){
            int cnt = 0;
            for(int j=0; j<targets[i].length(); j++){
                char c = targets[i].charAt(j);
                if(map.get(c) != null){
                    cnt += map.get(c);    
                }
                else{
                    cnt = -1;
                    break;
                }
            }
            result[i] = cnt;
        }
        
        return result;
    }
}
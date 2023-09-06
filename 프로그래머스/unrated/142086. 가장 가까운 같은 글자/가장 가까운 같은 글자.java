import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.get(c) == null){
                map.put(c, i);
                result[i] = -1;
            }
            else{
                result[i] = i - map.get(c);
                map.put(c, i);
            }
        }
        return result;
    }
}
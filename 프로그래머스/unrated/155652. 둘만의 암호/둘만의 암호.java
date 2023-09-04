import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Integer, Character> map2 = new HashMap<>();
        HashMap<Character, Boolean> map3 = new HashMap<>();
        
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for(int i=0; i<alpha.length(); i++){
            char c = alpha.charAt(i);
            map.put(c, i);
            map2.put(i, c);
        }
        for(int i=0; i<skip.length(); i++){
            char c = skip.charAt(i);
            map3.put(c, true);
        }
        String result = "";
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int cnt = 0;
            int idx = map.get(c);
            while(true){
                if(cnt == index){
                    result += Character.toString(map2.get(idx));
                    break;
                }
                idx++;
                if(idx >= alpha.length()) idx = idx%alpha.length();
                if(map3.get(map2.get(idx)) != null) continue;
                cnt++;
            }
        }
        
        return result;
    }
}
import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();    
        HashMap<Integer, String> map2 = new HashMap<>();
        String[] last = new String[players.length];
        
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
            map2.put(i, players[i]);
            last[i] = players[i];
        }
        
        for(int i=0; i<callings.length; i++){
            int cur = map.get(callings[i]);
            int before = cur-1;
            String before_man = map2.get(before);
                                         
            map.put(callings[i], before);
            map2.put(before, callings[i]);
            map.put(before_man, cur);
            map2.put(cur, before_man);
            
            last[cur] = before_man;
            last[before] = callings[i];
        }
        return last;
    }
}
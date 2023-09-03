import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int[] result = new int[photo.length];
        
        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }
        
        for(int i=0; i<photo.length; i++){
            int point = 0;
            for(int j=0; j<photo[i].length; j++){
                if(map.get(photo[i][j]) == null) continue;
                point += map.get(photo[i][j]);
            }
            result[i] = point;
        }
        
        return result;
    }
}
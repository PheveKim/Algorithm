import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

class Solution {
    static int map_size;
    static char[] alpha;
    static int order_len;
    static HashMap<Character, int[]> map;
    static int max_same_cnt;
    static ArrayList<int[]> ans;
    public String[] solution(String[] orders, int[] course) {
        order_len = orders.length;
        // 1 1 0 1 0 1
        // 1 1 1 1 1 1
        
        // A : 1,2,4,6
        // B : 1,5
        // C : 1,2,3,4,5,6
        // D : 3,4,6
        // E : 3,4,6
        // F : 1,5
        // G : 1,5
        // H : 6
        
        map = new HashMap<>();
        for(int i=0; i<orders.length; i++){
            String target = orders[i];
            for(int j=0; j<target.length(); j++){
                if(map.get(target.charAt(j)) == null){
                    map.put(target.charAt(j), new int[orders.length]);
                }
                map.get(target.charAt(j))[i] = 1;
            }
        }
        map_size = map.size();
        alpha = new char[map_size];
        int idx = 0;
        for(char key : map.keySet()){
            // System.out.println(key + " " + Arrays.toString(map.get(key)));
            alpha[idx] = key;
            idx++;
        }
        ans = new ArrayList<>();
        ArrayList<String> answer2 = new ArrayList<>();
        for(int i=0; i<course.length; i++){
            max_same_cnt = 2;
            ans.clear();
            dfs(0,0, new int[course[i]]);
            for(int j=0; j<ans.size(); j++){
                String a = "";
                for(int k=0; k<ans.get(j).length; k++){
                    a += alpha[ans.get(j)[k]];
                }
                answer2.add(a);
            }
        }
        Collections.sort(answer2);
        String[] answer = new String[answer2.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = answer2.get(i);
        }
        return answer;
    }
    
    public static void dfs(int cnt, int last_idx, int[] chosen){
        
        if(cnt >= chosen.length){
            int same_cnt = 0;
            for(int i=0; i<order_len; i++){
                int first = 0;
                boolean same = true;
                Loop2: for(int j=0; j<chosen.length; j++){
                    char c = alpha[chosen[j]];
                    if(j==0){
                        first = map.get(c)[i];
                        if(first == 0){
                            same = false;
                            break Loop2;
                        } 
                    }
                    if(map.get(c)[i] != first){
                        same = false;
                        break Loop2;
                    }
                }
                if(same == true) same_cnt++;
            }
            
            if(max_same_cnt < same_cnt){
                max_same_cnt = same_cnt;
                ans.clear();
                int[] chosen_copy = new int[chosen.length];
                chosen_copy = Arrays.copyOf(chosen, chosen.length);
                ans.add(chosen_copy);
            }
            else if(max_same_cnt == same_cnt){
                int[] chosen_copy = new int[chosen.length];
                chosen_copy = Arrays.copyOf(chosen, chosen.length);
                ans.add(chosen_copy);
            }
        }
        else{
            for(int i=last_idx; i<map_size; i++){
                chosen[cnt] = i;
                dfs(cnt+1, i+1, chosen);
                chosen[cnt] = 0;
            }
        }
    }
}
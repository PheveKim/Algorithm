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
        // A : 1 1 0 1 0 1
        // C : 1 1 1 1 1 1
        
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
                ans.add(Arrays.copyOf(chosen, chosen.length)); // 이렇게 하면 새롭게 선언할 필요 없음. 그냥 chosen 넣으면, chosen 값이                                                                // 바뀔때마다 ans안의 chosen 도 바뀌게됨(주소가 같기 때문)
            }
            else if(max_same_cnt == same_cnt){
                ans.add(Arrays.copyOf(chosen, chosen.length));
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
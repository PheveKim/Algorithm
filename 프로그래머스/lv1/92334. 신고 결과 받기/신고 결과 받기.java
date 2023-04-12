import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        StringTokenizer st;
        
        int[] report_cnt = new int[id_list.length];
        // 신고횟수 카운트 모두 0으로 초기화.
        // HashMap<Integer> map = new HashMap<>();
        HashMap<String, ArrayList<String>> map = new LinkedHashMap<>();
        HashMap<String, Integer> map_report = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], new ArrayList<String>());
        }
        
        for(int i=0; i<report.length; i++){
            if(map_report.get(report[i]) != null){
                continue;
            }
            map_report.put(report[i], 1);
            
            st = new StringTokenizer(report[i], " ");
                        
            String from = st.nextToken();
            String to = st.nextToken();
            
            
            for(int j=0; j<id_list.length; j++){
                if(to.equals(id_list[j])){
                    report_cnt[j]++;
                    break;
                }
            }
            // System.out.println("from" + " " + from);
            map.get(from).add(to);
        
        }
        int idx = 0;
        for(String key: map.keySet()){
            int total_cnt = 0;
            // System.out.println(map.get(key));
            for(int i=0; i<map.get(key).size(); i++){
                String target = map.get(key).get(i);
                for(int j=0; j<id_list.length; j++){
                    if(target.equals(id_list[j])){
                        if(report_cnt[j] >= k){
                            total_cnt++;
                        }
                        break;
                    }
                }
            }
            answer[idx] = total_cnt;
            idx++;
        }
        
        
        
        return answer;
    }
}
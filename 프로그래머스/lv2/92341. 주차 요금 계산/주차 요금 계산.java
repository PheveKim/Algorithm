import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        StringTokenizer st;
        
        int[] answer = {};
        int basic_min = fees[0];
        int basic_fee = fees[1];
        int base = fees[2];
        int over_fee = fees[3];
        
        HashMap<Integer, ArrayList<String[]>> map = new HashMap<>(); 
        
        for(int i=0; i<records.length; i++){
            st = new StringTokenizer(records[i], " ");            
            String time = st.nextToken();
            int car_num = Integer.parseInt(st.nextToken());
            String in_out = st.nextToken();
            map.put(car_num, new ArrayList<String[]>());
        }
        
        // "차 번호" : {시간, IN/OUT}
        for(int i=0; i<records.length; i++){
            st = new StringTokenizer(records[i], " ");            
            String time = st.nextToken();
            int car_num = Integer.parseInt(st.nextToken());
            String in_out = st.nextToken();
            
            
            map.get(car_num).add(new String[] {time, in_out});
        }
        
        ArrayList<Integer> car_num_sorted = new ArrayList<>();
        for(int key: map.keySet()){
            car_num_sorted.add(key);
        }
        Collections.sort(car_num_sorted);
        
        answer = new int[map.size()];
        int idx = 0;
        for(int k=0; k<car_num_sorted.size(); k++){
            int key = car_num_sorted.get(k);
            int total_min_diff = 0;
            int min_total_before = 0;
            boolean in_only = true;
            
            for(int i=0; i<map.get(key).size(); i++){
                String[] target = map.get(key).get(i);
                String time = target[0];
                String in_out = target[1];
                
                st = new StringTokenizer(time, ":");
                int hour = Integer.parseInt(st.nextToken());
                int min = Integer.parseInt(st.nextToken());
                int min_total = hour * 60 + min;
                
                if(in_out.equals("IN")){
                    min_total_before = min_total;
                    in_only = true;
                }
                else if(in_out.equals("OUT")){
                    in_only = false;
                    int min_diff = min_total - min_total_before;
                    total_min_diff += min_diff;
                }
                
            }
            
            if(in_only == true){
                int last_min = 23*60 + 59;
                int min_diff = last_min - min_total_before;
                total_min_diff += min_diff;
            }
            // System.out.println(total_min_diff);
            int fee = 0;
            if(total_min_diff <= basic_min){
                fee = basic_fee;
            }
            else{
                double diff_d = total_min_diff - basic_min;
                double base_d = base;
                
                fee = basic_fee + 
                    (int) Math.ceil(diff_d/base_d) * over_fee;
            }
            // System.out.println((total_min_diff - basic_min)/base);
            // System.out.println(Math.ceil((total_min_diff - basic_min)/base));
            answer[idx] = fee;
            idx++;
        }
        
        // 입차된 후에 출차된 내역이 없다면, 23:59에 출차된 것으로 간주합니다.
        
        // 5000 + ⌈(334 - 180) / 10⌉ x 600 = 14600
        // 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림합니다.
        return answer;
    }
}
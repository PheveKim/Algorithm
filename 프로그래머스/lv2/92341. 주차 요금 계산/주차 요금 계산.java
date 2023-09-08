import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        // 입차 -> 출차 : 차이 계산.
        // 다시 입차 -> 출차 : 차이 계산.
        
        // 입차되어있는 차가 있는지 여부 해시맵.
        // 입차 시간 해시맵.
        // 입차 get 했는데 != null 이면 출차한것이므로 시간 차이 계산하고
        // null 로 바꾸고, 입차여부해시맵을 false 로 변경.
        
        HashMap<String, Integer> map_in = new HashMap<>();
        HashMap<String, Boolean> isin = new HashMap<>();
        HashMap<String, Integer> map_time = new HashMap<>();
        
        StringTokenizer st;
        for(int i=0; i<records.length; i++){
            st = new StringTokenizer(records[i], " ");
            String time = st.nextToken();
            String number = st.nextToken();
            String inout = st.nextToken();
            
            st = new StringTokenizer(time, ":");
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            int time_int = hour * 60 + minute;
            
            if(inout.equals("IN")){
                map_in.put(number, time_int);
                isin.put(number, true);
            }
            else if (inout.equals("OUT")){
                int before = map_in.get(number);
                int time_diff = time_int - before;
                
                if(map_time.get(number) != null){
                    map_time.put(number, map_time.get(number) + time_diff);       
                }
                else{
                    map_time.put(number, time_diff);
                }
                isin.put(number, false);
            }
        }
        
        int last_time = 23 * 60 + 59;
        for(String key: isin.keySet()){
            if(isin.get(key) == true){
                int time_diff = last_time - map_in.get(key);
                if(map_time.get(key) != null){
                    map_time.put(key, map_time.get(key) + time_diff);       
                }
                else{
                    map_time.put(key, time_diff);
                }
            }
        }
        
        HashMap<Integer, Integer> ans = new HashMap<>();
        for(String key: map_time.keySet()){
            int time = map_time.get(key);
            if(time > fees[0]){
                int remain = 0;
                if((time - fees[0]) % fees[2] > 0) remain = 1;
                ans.put(Integer.parseInt(key), fees[1] + ((time - fees[0]) / fees[2] + remain) * fees[3]);
            }
            else{
                ans.put(Integer.parseInt(key), fees[1]);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int key: ans.keySet()){
            list.add(key);
        }
        
        Collections.sort(list);
        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            result[i] = ans.get(list.get(i));
        }
        
        return result;
    }
}
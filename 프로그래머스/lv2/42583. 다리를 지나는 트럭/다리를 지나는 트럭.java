import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<truck_weights.length; i++){
            q.add(truck_weights[i]);
        }
        
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        int q2_sum = 0;
        int cnt = 0;
        
        while(true){
            
            if(q2.size() >= 1 && q3.peek() <= cnt){
                q2_sum -= q2.peek();
                q2.poll();
                q3.poll();
            }
            
            if(q.size() >= 1){
                int top = q.peek();
                if(q2_sum + top <= weight && q2.size() + 1 <= bridge_length){
                    q2.add(top);
                    q2_sum += top;
                    q3.add(cnt + bridge_length);
                    q.poll();
                }
            }
            
            if(q.size() == 0 && q2.size() == 0) break;
            cnt++;    
        
        }
        
        return cnt+1;
    }
}
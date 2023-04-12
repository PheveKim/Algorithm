import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int solution(int n, int k) {
        StringTokenizer st;
        int answer = 0;
        // n = 1;
        // k = 3;
        // Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> q = new ArrayList<>();
        while(true){
            int up = n / k;
            int left = n % k;
            q.add(left);
            n = up;
            if(n < k) {
                q.add(n);
                break;
            }
        }
        
        // System.out.println(q);
        String str = "";
        for(int i=q.size()-1; i>=0; i--){
            str += Integer.toString(q.get(i));
        }
        st = new StringTokenizer(str, "0");
        int st_len = st.countTokens();
        // System.out.println(str);
        for(int i=0; i<st_len; i++){
            String target = st.nextToken();
            // System.out.println(st.nextToken());
            // System.out.println(target)l
           
            // for(int j=0; j<target.length(); j++){
            //     int num = Integer.parseInt(target.substring(j, j+1));
            //     decimal += num * Math.pow(k, j);
            // }
            long decimal = Long.parseLong(target);
            boolean prime = true;
            // System.out.println(decimal);
        
            
            for(int j=2; j<= (int)Math.sqrt(decimal); j++){
                if(decimal % j == 0){
                    // System.out.println(decimal);
                    prime = false;
                    break;
                }
            }
            if(decimal == 1) prime = false;
            if(prime == true) answer++;
            
            
        }
        return answer;
    }
}
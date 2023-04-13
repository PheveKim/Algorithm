import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        // terms 유효기간
        // today 오늘날짜
        // 파기해야할 개인정보를 리턴.
        // day 가 01 이면, 달수 더하고 난뒤에는, 28일로 변경. ~28일까지.
        StringTokenizer st;
        st = new StringTokenizer(today, ".");
        int this_year = Integer.parseInt(st.nextToken());
        int this_month = Integer.parseInt(st.nextToken());
        int this_day = Integer.parseInt(st.nextToken());
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<terms.length; i++){
            st = new StringTokenizer(terms[i], " ");
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        for(int i=0; i<privacies.length; i++){
            
            st = new StringTokenizer(privacies[i], " ");
            String date = st.nextToken();
            String term = st.nextToken();
            int term2 = map.get(term);
            st = new StringTokenizer(date, ".");
            int target_year = Integer.parseInt(st.nextToken());
            int target_month = Integer.parseInt(st.nextToken());
            int target_day = Integer.parseInt(st.nextToken());
            
            if(target_day == 1){
                target_day = 28;
                target_month += term2 - 1;
            }
            else{
                target_day--;
                target_month += term2;
            }
            while(true){
                if(target_month > 12){
                    target_month = target_month - 12;
                    target_year++;
                }
                else break;
            }
            
            // System.out.println(this_year + " " + this_month + " " + this_day);
            // System.out.println(target_year + " " + target_month + " " + target_day);
            boolean outdated = false;
            if(this_year > target_year) outdated = true;
            else if(this_year < target_year) outdated = false;
            else if(this_year == target_year){
                if(this_month > target_month) outdated = true;
                else if(this_month < target_month) outdated = false;
                else if(this_month == target_month){
                    if(this_day > target_day) outdated = true;
                    else outdated = false;
                }
            }
            if(outdated == true) answer.add(i+1);
        }
        
        int[] answer2 = new int[answer.size()];
        for(int i=0; i<answer2.length; i++){
            answer2[i] = answer.get(i);
        }
        return answer2;
    }
}
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

class Solution {
    public static void print(Object object){
        System.out.println(object);
    }    
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        // int[] RCJA = new int[ArrayList<>()];
        int[] RCJA = new int[4];
        int[] TFMN = new int[4];
        String[] RCJA_S = {"R", "C", "J", "A"};
        String[] TFMN_S = {"T", "F", "M", "N"};
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 1);
        map.put("F", 1);
        map.put("J", 2);
        map.put("M", 2);
        map.put("A", 3);
        map.put("N", 3);
        
        map2.put("R", 0);
        map2.put("T", 1);
        map2.put("C", 0);
        map2.put("F", 1);
        map2.put("J", 0);
        map2.put("M", 1);
        map2.put("A", 0);
        map2.put("N", 1);
        
        // ArrayList<Integer>[] RCJA = new ArrayList[4];
        // ArrayList<Integer>[] TFMN = new ArrayList[4];
        // for(int i=0; i<4; i++){
        //     RCJA[i] = new ArrayList<>();
        //     TFMN[i] = new ArrayList<>();
        // }
        // print(Arrays.toString(RCJA));
        // print(Arrays.toString(TFMN));
        
        
        for(int i=0; i<survey.length; i++){
            
            String s = survey[i];
            String s1 = s.substring(0,1);
            String s2 = s.substring(1,2);
            int c = choices[i];
            
            int idx = map.get(s1);
            if(c >= 5){
                if(map2.get(s2) == 0){
                    RCJA[idx] += c-4;
                }
                else{
                    TFMN[idx] += c-4;
                }
            }
            else if(c <= 3){
                if(map2.get(s1) == 0){
                    RCJA[idx] += 4-c;
                }
                else{
                    TFMN[idx] += 4-c;
                }
            }    
        }
        for(int i=0; i<4; i++){
            if(RCJA[i] >= TFMN[i]){
                answer += RCJA_S[i];
            }
            else if(RCJA[i] < TFMN[i]){
                answer += TFMN_S[i];
            }
        }
        // print(Arrays.toString(RCJA));
        // print(Arrays.toString(TFMN));
        
        
        return answer;
    }
}
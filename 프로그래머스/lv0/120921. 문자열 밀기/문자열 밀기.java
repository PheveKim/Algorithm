import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        
        while(true){
            
            if(A.equals(B)) break;
            else if(answer > A.length()){
                answer = -1;
                break;
            }
            
            A = A.substring(A.length()-1, A.length()) + A.substring(0, A.length()-1);
            
            answer++;
        }
        
        
        return answer;
    }
}
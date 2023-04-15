import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        
        int len = 0;
        if(my_str.length() % n == 0) len = my_str.length()/n;
        else len = my_str.length()/n + 1;
        String[] div = new String[len];
        
        for(int i=0; i<div.length; i++){
            String part = "";
            if(my_str.length() >= n){
                part = my_str.substring(0, n);
                my_str = my_str.substring(n, my_str.length());
            }
            else{
                part = my_str;
                my_str = "";
            }
            div[i] = part;
        }
        answer = Arrays.copyOf(div, div.length);
        
        return answer;
    }
}
import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int solution(int[] array) {
        int cnt = 0;
        for(int i=0; i<array.length; i++){
            int num = array[i];
            while(true){
                int mok = num / 10;
                int left = num % 10;
                if(left == 7){
                    cnt++;
                }
                if(mok == 0) break;
                num = mok;
            }
        }
        return cnt;
    }
}
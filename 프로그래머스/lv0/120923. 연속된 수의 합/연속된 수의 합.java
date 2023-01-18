import java.util.Arrays;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = {};
        
        // a, a+d, a+2d, a+3d, a+4d, ... , a+(num-1)d = total
        // num * a + num*(num+1)/2 = total
        // num * a = total - num*(num+1)/2
        // a = (total-num*(num+1)/2)/num
        
        int a = (total-num*(num+1)/2)/num;
        int[] arr = new int[num];
        
        
        for(int i=0; i<num; i++) arr[i] = a + i + 1;
        answer = arr;
        
        
        
        return answer;
    }
}
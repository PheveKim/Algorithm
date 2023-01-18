class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        
        int d1 = common[2] - common[1];
        int d2 = common[1] - common[0];
            
        if(d1==d2){
            answer = common[common.length-1] + d1;
        }
        else{
            if(common[0] == 0) answer = 0;
            else{
                int r = common[1] / common[0];
                answer = common[common.length-1] * r;
            }
        }
        
        
        
        
        
        
        return answer;
    }
}
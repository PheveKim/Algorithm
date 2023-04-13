import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

class Solution {
    static int n2;
    static int[] info2;
    static int[] ans;
    static int max_diff;
    static int least_point;
    static int least_cnt;
    
    public int[] solution(int n, int[] info) {
        int[] answer = {};
       
        int info_len = info.length;
        ans = new int[info_len];
        info2 = new int[info_len];
        max_diff = -1;
        n2 = n;
        
        least_point = 10;
        least_cnt = 0;
        
        for(int i=0; i<info_len; i++){
            info2[i] = info[i];
        }
        
        dfs(0,0,new int[info_len]);
        
        
        
        
        
        if(max_diff == -1) return new int[] {-1};
        return ans;
    }
    
    public static void dfs(int cnt, int last_idx, int[] chosen){
    
        if(cnt >= n2){
            // System.out.println(Arrays.toString(info2));
            // System.out.println(Arrays.toString(chosen));
            
            int appeach_point = 0;
            int lion_point = 0;
            for(int i=0; i<chosen.length; i++){
                
                int point = 10 - i;
                if(info2[i]==0 && chosen[i]==0){
                    continue;
                }
                if(info2[i] > chosen[i]){
                    appeach_point += point;
                }
                else if(info2[i] == chosen[i]){
                    appeach_point += point;
                }
                else if(info2[i] < chosen[i]){
                    lion_point += point;
                }
                
            }
            // System.out.println(lion_point + " " + appeach_point);
            if(lion_point > appeach_point){
                
                if(max_diff < lion_point - appeach_point){
                    max_diff = lion_point - appeach_point;
                    ans = Arrays.copyOf(chosen, chosen.length);
                    // for(int j=ans.length-1; j>=0; j--){
                    //     if(ans[j] > 0){
                    //         least_point = j;
                    //         least_cnt = ans[j];
                    //         break;
                    //     }
                    // }
                }
                else if(max_diff == lion_point - appeach_point){
                    int ans_least = 10;
                    int ans_cnt = 0;
                    int chosen_least = 10;
                    int chosen_cnt = 0;
                    for(int j=chosen.length - 1; j>=0; j--){
                        
                        if(ans[j] > 0 && ans_least > chosen.length - j - 1){
                            ans_least = chosen.length - j - 1;
                            ans_cnt = ans[j];
                        }
                        if(chosen[j] > 0 && chosen_least > chosen.length - j - 1){
                            chosen_least = chosen.length - j - 1;
                            chosen_cnt = chosen[j];
                        }
                        if(ans_least > chosen_least){
                            ans = Arrays.copyOf(chosen, chosen.length);
                            break;
                        }
                        else if(ans_least == chosen_least){
                            if(ans_cnt < chosen_cnt){
                                ans = Arrays.copyOf(chosen, chosen.length);
                                break;
                            }
                        }
                        else continue;
                        
                    }
                    
                    
//                     for(int j=chosen.length-1; j>=0; j--){
//                         int real_point = chosen.length - j - 1;
//                         if(chosen[j] > 0){
//                             if(least_point > real_point){
//                                 ans = Arrays.copyOf(chosen, chosen.length);
//                                 least_point = real_point;
//                                 least_cnt = chosen[j];
//                             }
//                             else if(least_point == real_point){
//                                 if(least_cnt < chosen[j]){
//                                     ans = Arrays.copyOf(chosen, chosen.length);
//                                     least_point = real_point;
//                                     least_cnt = chosen[j];
//                                 }
//                             }
//                             break;
//                         }
//                     }
                }
                
            }
            
            
        }

        else{
            for(int i=last_idx; i<chosen.length; i++){
                chosen[i]++;
                dfs(cnt+1, i, chosen);
                chosen[i]--;
            }
        }
    }
}
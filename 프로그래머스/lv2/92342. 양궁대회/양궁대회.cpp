#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> info_copy;
int n_copy;
vector<int> answer;
int max_diff;

void copy_vector(int chosen[11]){
    answer.clear();
    for(int i=0; i<11; i++){
        answer.push_back(chosen[i]);
    }
}
void dfs(int cnt, int last_idx, int chosen[11]){
    
    if(cnt >= n_copy){
        int appeach_point = 0;
        int lion_point = 0;
        for(int i=0; i<11; i++){
            int appeach = info_copy[i];
            int lion = chosen[i];
            
            if(appeach == 0 && lion == 0) continue;
            if(appeach >= lion) appeach_point += 10-i;
            if(appeach < lion) lion_point += 10-i;
        }
        
        if(appeach_point < lion_point){
            int diff = lion_point - appeach_point;
            if(max_diff < diff){
                max_diff = diff;
                copy_vector(chosen);
            }
            else if(max_diff == diff){
                for(int j=10; j>=0; j--){
                    if(answer[j] == 0 && chosen[j] == 0) continue;
                    if(answer[j] > chosen[j]){
                        break;
                    }
                    else if(answer[j] == chosen[j]){
                        continue;
                    }
                    else if(answer[j] < chosen[j]){
                        copy_vector(chosen);
                        break;
                    }
                }
            }
        }
    }
    else{
        for(int i=last_idx; i<11; i++){
            chosen[i]++;
            dfs(cnt+1, i, chosen);
            chosen[i]--;
        }    
    }
}
vector<int> solution(int n, vector<int> info) {
    
    for(int i=0; i<info.size(); i++){
        info_copy.push_back(info[i]);
    }
    n_copy = n;
    
    int chosen[11];
    for(int i=0; i<11; i++){
        chosen[i] = 0;
    }
    max_diff = -1;
    dfs(0,0,chosen);
    if(max_diff == -1) answer.push_back(-1);
    return answer;
}





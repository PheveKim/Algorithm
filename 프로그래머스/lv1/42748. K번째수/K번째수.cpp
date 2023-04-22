#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    
    for(int i=0; i<commands.size(); i++){
        int from = commands[i][0];
        int to = commands[i][1];
        int idx = commands[i][2];
        
        vector<int> temp;
        for(int j=from-1; j<to; j++){
            temp.push_back(array[j]);
        }
        sort(temp.begin(), temp.end());
        answer.push_back(temp[idx-1]);
    }
    // for(int i=0; i<answer.size(); i++){
    //     cout << answer[i] << " ";
    // }
    
    
    vector<int> answer2;
    vector<int> input = {5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
    vector<int> temp;
    int n = 5;
    int k = 3;
    int p, done;
    
    for(int i=0; i<n; i++){
        temp.push_back(0);
    }
    
    
    for(int i=0; i<input.size(); i++){
        
        
        if(temp[ input[i]-1 ] < k){ // 해당 층으로
            temp[ input[i] - 1 ]++;
            answer2.push_back(input[i]);
        }
        
        
        else{
            p = 1;
            done = 0;
            
            if( input[i] - 1 == 0 ){  // 1 층이면
                
                while(!done){
                    if( temp[input[i] - 1 + p] < k){  // 위에 층으로

                            temp[ input[i] - 1 + p ]++;
                            answer2.push_back(input[i] + p);
                            done = 1;

                        }
                    else{
                        p++;
                    }
                }
                
            }
            
            
            else if( input[i] - 1 == n-1 ){ // 꼭대기 층이면
                
                while(!done){
                    if( temp[input[i] - 1 - p] < k ){ // 밑에 층으로

                            temp[ input[i] - 1 - p ]++;
                            answer2.push_back(input[i] - p );
                            done = 1;

                        }

                    else{
                        p++;
                    }
                }
                
            }
            
            
            
            else{  // 그 사이 층이면
                
                while(!done){
                
                
                    if( input[i] - 1 - p >= 0 && temp[input[i] - 1 - p] < k ){ // 밑에 층으로

                        temp[ input[i] - 1 - p ]++;
                        answer2.push_back(input[i] - p );
                        done = 1;

                    }


                    else if( input[i] -1 + p < n && temp[input[i] - 1 + p] < k){  // 위에 층으로

                        temp[ input[i] - 1 + p ]++;
                        answer2.push_back(input[i] + p);
                        done = 1;

                    }

                    else{
                        p++;
                    }
            
                }
                
            }
            
            
        }
        
        
    }
    
    
    // for(int i=0; i<answer2.size(); i++){
    //     printf("%d\t", answer2[i]);
    // }
    
    
    
    
    
    
    
    
    return answer;
}
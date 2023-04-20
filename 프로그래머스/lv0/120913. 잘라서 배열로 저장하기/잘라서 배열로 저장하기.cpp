#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<string> solution(string my_str, int n) {
    vector<string> answer;
    
    while(true){
        
        if(my_str.length() >= n){
            answer.push_back(my_str.substr(0, n));
            my_str = my_str.substr(n);
        }
        else if(my_str.length() == 0){
            break;
        }
        else{
            answer.push_back(my_str);
            break;
        }
        
    }
    
    
    
    
    return answer;
}
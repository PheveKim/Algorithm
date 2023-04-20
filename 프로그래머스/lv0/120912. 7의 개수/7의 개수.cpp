#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> array) {
    
    int cnt = 0;
    for(int i=0; i<array.size(); i++){
        
        int num = array[i];
        while(true){
            int mok = num / 10;
            int left = num % 10;
            if(left == 7) cnt++;
            if(mok == 0) break;
            num = mok;
        }
                
    }
    
    
    return cnt;
}
#include <string>
#include <vector>

using namespace std;

vector<int> solution(int num, int total) {
    vector<int> answer;
    
    // a, a+d, a+2d, a+3d, a+(n-1)d
    // = a*n + d+2d+3d+..(n-1)d
    // = a*n + (n*(n-1)/2)*d
    // = total
    // d = 1
    // a = (total - n(n-1)/2) / n
    int a = (total - num*(num-1)/2) / num;
    for(int i=0; i<num; i++){
        answer.push_back(a+i);
    }
    
    return answer;
}
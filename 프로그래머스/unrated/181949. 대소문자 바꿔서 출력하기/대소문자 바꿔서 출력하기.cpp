#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    
    string a = "abcdefghijklmnopqrstuvwxyz";
    string A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    for(int i=0; i<str.size(); i++){
        
        for(int j=0; j<a.size(); j++){
            if(str.at(i) == a.at(j)){
                cout << A.at(j);
                break;
            }
            else if(str.at(i) == A.at(j)){
                cout << a.at(j);
                break;
            }
        }
        
    }
    
    return 0;
}
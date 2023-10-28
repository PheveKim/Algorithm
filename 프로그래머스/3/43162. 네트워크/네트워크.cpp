#include <string>
#include <vector>
#include <iostream>
#include <map>
#include <algorithm>


using namespace std;

int parent[201];

int findParent(int x){
    if(parent[x] == x) return x;
    return findParent(parent[x]);
}

bool unionSet(int x, int y){
    x = findParent(x);
    y = findParent(y);
    
    if(x==y) return false;
    if(x<=y) parent[y] = x;
    else parent[x] = y;
    return true;
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    
    for(int i=0; i<n; i++){
        parent[i] = i;
    }
    
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(i==j) continue;
            if(computers[i][j] == 1){
                unionSet(i,j);
            }
        }
    }
    for(int i=0; i<n; i++) parent[i] = findParent(i);
    
    sort(parent, parent+n);
    answer++;
    
    for(int i=0; i<n-1; i++) {
        if (parent[i] != parent[i+1]) answer++;
    }
    
    map<int, int> map;
    for(int i=0; i<n; i++){
        map[parent[i]] = 1;
    }
    
    return answer;
}
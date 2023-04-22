#include <string>
#include <vector>
#include <iostream>
#include <cmath>
#include <algorithm>
#include <queue>
#include <stack>

using namespace std;
int dr[] = {-1,1,0,0};
int dc[] = {0,0,-1,1};

void printarr(int arr[5][5]){
    for(int r=0; r<5; r++){
        for(int c=0; c<5; c++){
            cout << arr[r][c] << " ";
        }
        cout << endl;
    }
    cout << endl;
}
void printarr2(bool arr[5][5]){
    for(int r=0; r<5; r++){
        for(int c=0; c<5; c++){
            cout << arr[r][c] << " ";
        }
        cout << endl;
    }
    cout << endl;
}
void init_visited(bool visited[5][5]){
    for(int r=0; r<5; r++){
        for(int c=0; c<5; c++){
            visited[r][c] = false;
        }
    }
}
bool bc(int row, int col){
    if(row>=0 && row<5 && col>=0 && col<5) return true;
    else return false;
}
vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    
    for(int i=0; i<places.size(); i++){
        int arr[5][5];
        vector<tuple<int,int>> list;
        for(int r=0; r<5; r++){
            string target = places[i][r];
            for(int c=0; c<5; c++){
                char p = target.at(c);
                if(p == 'P'){
                    arr[r][c] = 1;
                    list.push_back(make_tuple(r, c));
                }
                else if(p == 'O'){
                    arr[r][c] = 0;
                }
                else if(p == 'X'){
                    arr[r][c] = 2;
                }       
            }
        }
        
        // for(int j=0; j<list.size(); j++){
        //     cout << get<0>(list[j]) << " " << get<1>(list[j]) << endl;
        // }
        // cout << endl;
        
        bool cant = false;
        bool all_break = false;
        
        for(int j=0; j<list.size(); j++){
            bool visited[5][5];
            init_visited(visited);
            
            int p_row = get<0>(list[j]);
            int p_col = get<1>(list[j]);
            queue<tuple<int,int,int>> q;
            q.push(make_tuple(p_row, p_col, 0));
            visited[p_row][p_col] = true;
            
            bool while_break = false;
            while(!q.empty()){
                int popped_row = get<0>(q.front());
                int popped_col = get<1>(q.front());
                int popped_dis = get<2>(q.front());
                q.pop();
                
                for(int k=0; k<4; k++){
                    int nr = popped_row + dr[k];
                    int nc = popped_col + dc[k];
                    int nd = popped_dis + 1;
                    if(nd > 2){
                        while_break = true;
                        break;
                    }
                    
                    if(bc(nr, nc) == true && visited[nr][nc] == false){
                        if(arr[nr][nc] == 2) continue;
                        if(arr[nr][nc] == 1){
                            cant = true;
                            while_break = true;
                            all_break = true;
                            break;
                        }
                        q.push(make_tuple(nr,nc,nd));
                        visited[nr][nc] = true;
                    }
                }
                if(while_break == true) break;
            }
            if(all_break == true) break;
        }
        if(cant == true) answer.push_back(0);
        else answer.push_back(1);
    }
    return answer;
}
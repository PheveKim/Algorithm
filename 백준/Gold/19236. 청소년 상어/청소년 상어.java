import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,-1,-1,-1,0,1,1,1};
    static int max;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        arr = new int[4][4];
        int[][] all_fish = new int[17][3]; // {row, col, direction}        
        all_fish[0][0] = -1;
        all_fish[0][1] = -1;
        
        for(int row=0; row<4; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<4; col++) {
                arr[row][col] = Integer.parseInt(st.nextToken());
                int direction = Integer.parseInt(st.nextToken())-1;
                all_fish[arr[row][col]][0] = row;
                all_fish[arr[row][col]][1] = col;
                all_fish[arr[row][col]][2] = direction;
            }
        }
        max = Integer.MIN_VALUE;
        dfs(0,0,0, arr, all_fish);
        System.out.println(max);
    }
    
    public static boolean bc(int row, int col) {
        if(row>=0 && row<4 && col>=0 && col<4) return true;
        else return false;
    }
    
    public static void dfs(int eaten_fish_sum, int start_row, int start_col, int[][] arr_input, int[][] all_fish_input) {
        
        // 배열 복사
        int[][] arr_copy = new int[4][4];
        int[][] all_fish_copy = new int[17][3];
        int eaten_fish_sum_copy = eaten_fish_sum;
        for(int r=0; r<4; r++) {
            arr_copy[r] = Arrays.copyOf(arr_input[r], 4);
        }
        for(int i=0; i<17; i++) {
            all_fish_copy[i] = Arrays.copyOf(all_fish_input[i], 3);
        }
        
        // 1. 해당위치 먹고
        // 2. 물고기 이동하고
        // 3. 상어위치로부터 nr, nc에 대해 dfs
        
        // 1. 해당위치 먹기
        int to_be_eaten = arr_copy[start_row][start_col];
        arr_copy[start_row][start_col] = 0;
        eaten_fish_sum_copy += to_be_eaten;
        max = Math.max(max, eaten_fish_sum_copy);
        
        all_fish_copy[to_be_eaten][0] = -1; // 먹은 물고기 인덱스 -1로 변환(고려하지않기위함)
        all_fish_copy[to_be_eaten][1] = -1;
        
        // 2. 물고기 이동하기
        for(int i=1; i<17; i++) {
            if(all_fish_copy[i][0] != -1) {
                
                int direction_temp = all_fish_copy[i][2];
                int cnt = 0;
                while(true) {
                    if(cnt >= 8) break;
                    int nr_t = all_fish_copy[i][0] + dr[direction_temp];
                    int nc_t = all_fish_copy[i][1] + dc[direction_temp];
                    
                    // swap
                    if(bc(nr_t, nc_t) && (nr_t != start_row || nc_t != start_col)) {
                        int current_row = all_fish_copy[i][0];
                        int current_col = all_fish_copy[i][1];
                        int swap_to_row = nr_t;
                        int swap_to_col = nc_t;
                        
                        int current_target = arr_copy[current_row][current_col];
                        int swap_to_target = arr_copy[swap_to_row][swap_to_col];
                        arr_copy[current_row][current_col] = swap_to_target;
                        arr_copy[swap_to_row][swap_to_col] = current_target;
                        
                        all_fish_copy[current_target][2] = direction_temp;
                        all_fish_copy[current_target][0] = swap_to_row;
                        all_fish_copy[current_target][1] = swap_to_col;
                        all_fish_copy[swap_to_target][0] = current_row;
                        all_fish_copy[swap_to_target][1] = current_col;
                        break;
                    }
                    // 45도 반시계방향 회전
                    else {
                        direction_temp++;
                        direction_temp %= 8;
                        cnt++;
                    }
                }
            }
        }
        
        
        // 상어의 먹은 이후 방향은 어떻게? -> 밑에서 nr, nc가 다음 상어의 위치가 되면서 방향도 all_fish_copy를 이용하여 확인.
        // 3. 상어위치로부터 nr, nc에 대해 dfs
        int k = 1;
        while(true) {
            int nr = start_row + dr[all_fish_copy[to_be_eaten][2]] * k;
            int nc = start_col + dc[all_fish_copy[to_be_eaten][2]] * k;
            
            if(bc(nr, nc) == false) break;
            if(arr_copy[nr][nc] == 0) { // 이 부분을 all_fish_copy[arr_copy[nr][nc]][0] == -1 이라고 해서 틀림.
                k++;					// 이유는, 먹으면 해당 arr은 0 으로변하지만 all_fish_copy에서는 좌표값이 -1로변하는데, 물고기이동시에 이 좌표가 변경될 수 있기 때문.
                continue;				// 즉, -1 이 다른 좌표로 변경되어 이 조건을 탈출해버릴 수도 있는것.
            }
            dfs(eaten_fish_sum_copy, nr, nc, arr_copy, all_fish_copy);
            k++;
        }
    }
}
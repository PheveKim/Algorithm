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
//        for(int r=0; r<4; r++) {
//            for(int c=0; c<4; c++) {
//                System.out.print(arr[r][c] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        max = Integer.MIN_VALUE;
        dfs(0,0,0, arr, all_fish);
        System.out.println(max);
        
    }
    
    public static boolean bc(int row, int col) {
        if(row>=0 && row<4 && col>=0 && col<4) return true;
        else return false;
    }
    
    public static void dfs(int eaten_fish_sum, int start_row, int start_col, int[][] arr_input, int[][] all_fish_input) {
        
//        System.out.println(eaten_fish_sum);
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
//        System.out.println(Arrays.deepToString(all_fish_copy));
        
        // 1. 해당위치 먹고
        // 2. 물고기 이동하고
        // 3. 상어위치로부터 nr, nc에 대해 dfs
        
        // 1. 해당위치 먹기
        int to_be_eaten = arr_copy[start_row][start_col];
        arr_copy[start_row][start_col] = 0;
        eaten_fish_sum_copy += to_be_eaten;
//        System.out.println(to_be_eaten);
        max = Math.max(max, eaten_fish_sum_copy);
        
        all_fish_copy[to_be_eaten][0] = -1; // 먹은 물고기 인덱스 -1로 변환(고려하지않기위함)
        all_fish_copy[to_be_eaten][1] = -1;
//        System.out.println(to_be_eaten + "  " + Arrays.deepToString(all_fish_copy));
//        
//        System.out.println("이동전");
//        for(int r=0; r<4; r++) {
//            for(int c=0; c<4; c++) {
//                System.out.print(arr_copy[r][c] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        // 2. 물고기 이동하기
        for(int i=1; i<17; i++) {
            if(all_fish_copy[i][0] != -1) {
                
                int direction_temp = all_fish_copy[i][2];
//                System.out.println(Arrays.deepToString(all_fish_copy));
//                System.out.println(i + "  " + direction_temp);
                int cnt = 0;
                while(true) {
                    if(cnt >= 8) break;
                    int nr_t = all_fish_copy[i][0] + dr[direction_temp];
                    int nc_t = all_fish_copy[i][1] + dc[direction_temp];
//                    System.out.println(nr_t + " " + nc_t);
                    // swap
                    if(bc(nr_t, nc_t) && (nr_t != start_row || nc_t != start_col)) {
                        
                        int current_row = all_fish_copy[i][0];
                        int current_col = all_fish_copy[i][1];
                        
                        int swap_to_row = nr_t;
                        int swap_to_col = nc_t;
                        
                        // all_fish_copy = [[-1, -1, 0], [1, 1, 7], [0, 1, 2], [1, 0, 0], [2, 2, 2], [3, 2, 1], [2, 0, 0], [-1, -1, 5], [3, 1, 6], [0, 3, 7], [1, 3, 0], [2, 3, 3], [3, 3, 1], [2, 1, 5], [1, 2, 6], [0, 2, 5], [3, 0, 0]]
                        int current_target = arr_copy[current_row][current_col];
                        int swap_to_target = arr_copy[swap_to_row][swap_to_col];
                        arr_copy[current_row][current_col] = swap_to_target;
                        arr_copy[swap_to_row][swap_to_col] = current_target;
                        
                        
                        all_fish_copy[current_target][2] = direction_temp;
                        all_fish_copy[current_target][0] = swap_to_row;
                        all_fish_copy[current_target][1] = swap_to_col;
                        all_fish_copy[swap_to_target][0] = current_row;
                        all_fish_copy[swap_to_target][1] = current_col;
//                        
//                        int[] temp = all_fish_copy[current_target];
//                        all_fish_copy[current_target] = all_fish_copy[swap_to_target];
//                        all_fish_copy[swap_to_target] = temp;
//                        all_fish_copy[current_target][2] = direction_temp;
//                        
                        // nr_t , nc_t 와 현재위치를 바꿔줄것임.
                        // 현재위치는 all_fish_copy[i][0], all_fish_copy[i][1];
                        
//                        
//                        System.out.println("이동후");
//                        for(int r=0; r<4; r++) {
//                            for(int c=0; c<4; c++) {
//                                System.out.print(arr_copy[r][c] + " ");
//                            }
//                            System.out.println();
//                        }
//                        System.out.println();
//                        
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
            if(arr_copy[nr][nc] == 0) {
                k++;
                continue;
            }
//            System.out.println(nr + "  " + nc);
            dfs(eaten_fish_sum_copy, nr, nc, arr_copy, all_fish_copy);
            k++;
        }
        
        
        
    }
}
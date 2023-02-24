import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
 
public class Solution {
 
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int max;
    static int N;
    static int[] wh_1_r = new int[5];
    static int[] wh_1_c = new int[5];
    static int[] wh_2_r = new int[5];
    static int[] wh_2_c = new int[5];
    static int[][] arr;
    static ArrayList<Integer> start_r = new ArrayList<>();
    static ArrayList<Integer> start_c = new ArrayList<>();
    static String[] D = {"up", "down", "left", "right"};
    static int k;
    static int point;
    static int next_row;
    static int next_col;
    static boolean direction_changed;
    static int r_dir;
    static int c_dir;
    static int nr;
    static int nc;
    static String direction;
    
    
    
    public static void main(String[] args) throws IOException {
 
    	Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
 
            N = scanner.nextInt();
            arr = new int[N][N];
            start_r.clear();
            start_c.clear();
            Arrays.fill(wh_1_r, -1);
            Arrays.fill(wh_1_c, -1);
            Arrays.fill(wh_2_r, -1);
            Arrays.fill(wh_2_c, -1);
             
             
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    int num = scanner.nextInt();
                    arr[row][col] = num;
                    if(num == 0) {
                    	start_r.add(row);
                    	start_c.add(col);
                    }
                    if(num >= 6 && num <= 10) {
                        int idx = num%6;
                        if(wh_1_r[idx] == -1) {
                            wh_1_r[idx] = row;
                            wh_1_c[idx] = col;
                        }
                        else {
                            wh_2_r[idx] = row;
                            wh_2_c[idx] = col;
                        }
                                             
                    }
                }
            }
 
            max = 0;
            for(int i=0; i<start_r.size(); i++) {
            	pinball(arr, start_r.get(i), start_c.get(i));
            }
 
            System.out.println("#" + (t + 1) + " " + max);
            
        }
    }
 
    public static void pinball(int[][] arr, int row, int col) {
    	
        for(int i=0; i<4; i++) {
            direction = D[i];
            k = 1;
            point = 0;
            next_row = row;
            next_col = col;
            direction_changed = false;
            r_dir = dr[i];
            c_dir = dc[i];
             
            while(true) {
                if(direction_changed) {
                    for(int j=0; j<4; j++) {
                        if(D[j].equals(direction)) {
                            r_dir = dr[j];
                            c_dir = dc[j];
                        }
                    }
                }
                 
                nr = next_row + r_dir * k;
                nc = next_col + c_dir * k;
                 
                if(nr<0 || nr>=N || nc<0 || nc>=N) {
                	point = point * 2 + 1;
                	max = Math.max(max, point);
                	break;
                }
                 
                else {
                	
                	if(arr[nr][nc] == -1) {
                        // 다음 위치에 블랙홀 발견
                        max = Math.max(max, point);
                        break;
                    }
                	
                    else if(nr == row && nc == col) {
                        // 다음 위치가 처음 출발 위치
                        max = Math.max(max, point);
                        break;
                    }
                	
                	else if(arr[nr][nc] == 0) {
                         // 그냥 길일때는 방향으로 1칸 전진
                         direction_changed = false;
                         k++;
                    }
                     
                	else if(arr[nr][nc] == 1) {
                        point++;
                        next_row = nr;
                        next_col = nc;
                        direction_changed = true;
                        k = 1;
                        if(direction.equals("right")) direction = "left";
                        else if(direction.equals("left")) direction = "up";
                        else if(direction.equals("up")) direction = "down";
                        else if(direction.equals("down")) direction = "right";
                         
                    }
                    else if(arr[nr][nc] == 2) {
                        point++;
                        next_row = nr;
                        next_col = nc;
                        direction_changed = true;
                        k = 1;
                        if(direction.equals("right")) direction = "left";
                        else if(direction.equals("left")) direction = "down";
                        else if(direction.equals("up")) direction = "right";
                        else if(direction.equals("down")) direction = "up";
                    }
                    else if(arr[nr][nc] == 3) {
                        point++;
                        next_row = nr;
                        next_col = nc;
                        direction_changed = true;
                        k = 1;
                        if(direction.equals("right")) direction = "down";
                        else if(direction.equals("left")) direction = "right";
                        else if(direction.equals("up")) direction = "left";
                        else if(direction.equals("down")) direction = "up";
                    }
                    else if(arr[nr][nc] == 4) {
                        point++;
                        next_row = nr;
                        next_col = nc;
                        direction_changed = true;
                        k = 1;
                        if(direction.equals("right")) direction = "up";
                        else if(direction.equals("left")) direction = "right";
                        else if(direction.equals("up")) direction = "down";
                        else if(direction.equals("down")) direction = "left";
                    }
                    else if(arr[nr][nc] == 5) {
                        point = point * 2 + 1;
                        max = Math.max(max, point);
                        break;
                    }
                    else if(arr[nr][nc] >= 6 && arr[nr][nc] <= 10) {
                        // 다음 위치에 웜홀 발견
                    	int worm_num = arr[nr][nc]%6;
                        if(wh_1_r[worm_num] == nr && wh_1_c[worm_num] == nc) {
                            next_row = wh_2_r[worm_num];
                            next_col = wh_2_c[worm_num];
                        }
                        else {
                            next_row = wh_1_r[worm_num];
                            next_col = wh_1_c[worm_num];
                        }
                        k = 1;
                         
                    }
                	
                }
                
            }
            
        }
         
         
    }
 
}
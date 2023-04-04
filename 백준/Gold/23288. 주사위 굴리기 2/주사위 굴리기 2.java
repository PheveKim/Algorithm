import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] arr;
    static HashMap<String, String> dir_map_1 = new HashMap<>();
    static HashMap<String, String> dir_map_2 = new HashMap<>();
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 90도 시계방향 회전 : 북 -> 동 -> 남 -> 서 -> 북
        dir_map_1.put("north", "east");
        dir_map_1.put("east", "south");
        dir_map_1.put("south", "west");
        dir_map_1.put("west", "north");
        
        // 90도 반시계방향 회전  서 -> 남 -> 동 -> 북 -> 서
        dir_map_2.put("north", "west");
        dir_map_2.put("west", "south");
        dir_map_2.put("south", "east");
        dir_map_2.put("east", "north");
        
        // 주사위 아랫면값 A
        // 밑 칸(x,y)의 값 B
        // A > B -> 90도 시계방향 회전 (이동방향)
        // A < B -> 90도 반시계방향
        // A = B -> 변화 X
        // 칸 (x,y) 의 점수 =  칸(x,y)의값 B * 동서남북방향에의 B의개수 C
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        for(int r=0; r<n; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<m; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 각 좌표마다 bfs 때려서 각 좌표에 점수를 넣어둠.
        int[][] point = new int[n][m];
        for(int r=0; r<n; r++) {
        	for(int c=0; c<m; c++) {
        		boolean[][] visited = new boolean[n][m];
        		int p = 1;
        		Queue<int[]> q = new LinkedList<>();
        		q.add(new int[] {r,c});
        		visited[r][c] = true;
        		while(!q.isEmpty()) {
        			int[] popped = q.poll();
        			int popped_row = popped[0];
        			int popped_col = popped[1];
        			for(int i=0; i<4; i++) {
            			int nr = popped_row + dr[i];
            			int nc = popped_col + dc[i];
            			if(bc(nr, nc) == true && visited[nr][nc] == false && arr[nr][nc] == arr[popped_row][popped_col]) {
            				q.add(new int[] {nr,nc});
            				visited[nr][nc] = true;
            				p++;
            			}
            		}	
        		}
        		point[r][c] = arr[r][c] * p;
        	}
        }
        
        int[][] dice = new int[4][3];
        dice[0] = new int[] {0,2,0};
        dice[1] = new int[] {4,1,3};
        dice[2] = new int[] {0,5,0};
        dice[3] = new int[] {0,6,0};
        
        ans = 0; // 0에서 점수 시작.
        int current_r = 0;
        int current_c = 0;
        String dir = "east";
        int d = 0;
        
        for(int i=0; i<k; i++) {
        	if(dir.equals("east")) d = 3;
            else if(dir.equals("west")) d = 2;
            else if(dir.equals("south")) d = 1;
            else if(dir.equals("north")) d = 0;
            
            boolean done = false;
            while(true) {
            	if(done == true) break;
            	int nr = current_r + dr[d];
                int nc = current_c + dc[d];
                if(bc(nr,nc) == true) { // 만약 이동방향에 칸이 없다면, 반대방향으로 이동한다.

                	// 주사위를 굴리고,
                	roll(dice, dir);
                	
                	// 주사위의 맨 밑바닥 값 받아오고 (A), B와 비교
                	int A = bottom(dice);
                	int B = arr[nr][nc];
                	
                	String new_dir = "";
                	if(A>B) {
                		new_dir = dir_map_1.get(dir);
                	}
                	else if(A<B) {
                		new_dir = dir_map_2.get(dir);
                	}
                	else if(A==B) {
                		new_dir = dir;
                	}
                	dir = new_dir; // dir 갱신해줌.
                	
                	current_r = nr;
                	current_c = nc;
                	ans += point[nr][nc];
                	
                	done = true;
                }
                else { // 막혔을시 반대방향 전환.
                	if(d == 3) {
                		dir = "west";
                		d = 2;
                	}
                	else if(d == 2) {
                		dir = "east";
                		d = 3;
                	}
                	else if(d == 1) {
                		dir = "north";
                		d = 0;
                	}
                	else if(d == 0) {
                		dir = "south";
                		d = 1;
                	}
                }
            }
        }
        System.out.println(ans);
    }
    
    public static void printarr(int[][] arr) {
        for(int r=0; r<arr.length; r++) {
            for(int c=0; c<arr[0].length; c++) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void roll(int[][] dice, String dir) {
    	int temp1 = 0;
    	int temp2 = 0;
    	int temp3 = 0;
    	int temp4 = 0;
    	if(dir.equals("north")) {
    		temp1 = dice[0][1];
    		temp2 = dice[1][1];
    		temp3 = dice[2][1];
    		temp4 = dice[3][1];
    		dice[0][1] = temp2;
    		dice[1][1] = temp3;
    		dice[2][1] = temp4;
    		dice[3][1] = temp1;
    	}
    	else if(dir.equals("south")) {
    		temp1 = dice[0][1];
    		temp2 = dice[1][1];
    		temp3 = dice[2][1];
    		temp4 = dice[3][1];
    		dice[0][1] = temp4;
    		dice[1][1] = temp1;
    		dice[2][1] = temp2;
    		dice[3][1] = temp3;
    	}
    	else if(dir.equals("east")) {
    		temp1 = dice[1][0];
    		temp2 = dice[1][1];
    		temp3 = dice[1][2];
    		temp4 = dice[3][1];
    		dice[1][0] = temp4;
    		dice[1][1] = temp1;
    		dice[1][2] = temp2;
    		dice[3][1] = temp3;
    	}
    	else if(dir.equals("west")) {
    		temp1 = dice[1][0];
    		temp2 = dice[1][1];
    		temp3 = dice[1][2];
    		temp4 = dice[3][1];
    		dice[1][0] = temp2;
    		dice[1][1] = temp3;
    		dice[1][2] = temp4;
    		dice[3][1] = temp1;
    	}
    }

    public static int bottom(int[][] dice) {
    	return dice[3][1];
    }
    
    public static boolean bc(int row, int col) {
    	if(row>=0 && row<n && col>=0 && col<m) return true;
    	else return false;
    }
}
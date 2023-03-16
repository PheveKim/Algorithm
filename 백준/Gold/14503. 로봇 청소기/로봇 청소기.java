import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int n;
    static int m;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int cnt;
    static boolean finished;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];
        
        st = new StringTokenizer(br.readLine(), " ");
        int start_r = Integer.parseInt(st.nextToken());
        int start_c = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());
        
        for(int row=0; row<n; row++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int col=0; col<m; col++) {
        		arr[row][col] = Integer.parseInt(st.nextToken());
        	}
        }
        cnt = 1;
        finished = false;
        visited[start_r][start_c] = true;
        dfs(direction, start_r, start_c);
        System.out.println(cnt);
    }
    
    public static void dfs(int direction, int row, int col) {
    	boolean found_four = false;
    	
    	for(int i=1; i<5; i++) {
			int idx = direction - i;
    		if(idx < 0) idx = idx + 4;
    		
    		int nr = row + dr[idx];
        	int nc = col + dc[idx];
        	if(bc(nr, nc) == true) {
        		if(arr[nr][nc] == 0 && visited[nr][nc] == false && finished == false) {
        			visited[nr][nc] = true;
        			cnt++;
//        			System.out.println(nr + " " + nc + "    " + cnt);
        			dfs(idx, nr, nc);
        			found_four = true;
            		visited[nr][nc] = false;
        		}
        	}
    	}
    	
    	
    	// 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
    	boolean backward = false;
    	if(found_four == false) {
        	int nr_b = row + dr[direction] * (-1);
        	int nc_b = col + dc[direction] * (-1);
        	
        	if(bc(nr_b, nc_b) == true) {
        		if(arr[nr_b][nc_b] != 1 && finished == false) {
        			dfs(direction, nr_b, nc_b);
        			backward = true;
        		}
        	}
    	}
    	
    	if(found_four == false && backward == false) {
    		finished = true;
    	}
    }
    
    public static boolean bc(int row, int col) {
    	if(row>=0 && row<n && col>=0 && col<m) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
}
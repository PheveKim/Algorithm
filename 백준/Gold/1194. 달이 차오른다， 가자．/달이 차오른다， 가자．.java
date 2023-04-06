import java.math.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][1 << 6];
        
        int start_row = 0;
        int start_col = 0;
        for(int r=0; r<n; r++) {
            String str = br.readLine();
            for(int c=0; c<m; c++) {
                map[r][c] = str.charAt(c);
                if(map[r][c] == '0') {
                	start_row = r;
                	start_col = c;
                }
            }
        }

        int ans = bfs(start_row, start_col);
        System.out.println(ans);
    }

    public static int bfs(int start_row, int start_col) {
    	Queue<int[]> q = new LinkedList<>();
    	q.add(new int[] {start_row, start_col, 0, 0});
    	visited[start_row][start_col][0] = true;

        while (!q.isEmpty()) {
        	int[] popped = q.poll();
        	int popped_row = popped[0];
        	int popped_col = popped[1];
        	int popped_dis = popped[2];
        	int popped_key = popped[3];
        	
        	if(map[popped_row][popped_col] == '1') {
            	return popped_dis;
            }
        	
            for(int i = 0; i < 4; i++) {
            	int nr = popped_row + dr[i];
            	int nc = popped_col + dc[i];
            	int nk = popped_key;

                if(bc(nr, nc) == false || map[nr][nc] == '#') {
                	continue;
                }

                if('A' <= map[nr][nc] && map[nr][nc] <= 'F') {
                    if((nk & (1 << (map[nr][nc] - 'A'))) == 0) {
                    	continue;
                    }
                }

                if('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
                	nk = nk | (1 << (map[nr][nc] - 'a'));
                }

                if(visited[nr][nc][nk]) continue;
                visited[nr][nc][nk] = true;
                q.add(new int[] {nr, nc, popped_dis + 1, nk});
            }
        }
        return -1;
    }
    
    public static boolean bc(int row, int col) {
    	if(row>=0 && row<n && col>=0 && col<m) return true;
    	else return false;
    }
}
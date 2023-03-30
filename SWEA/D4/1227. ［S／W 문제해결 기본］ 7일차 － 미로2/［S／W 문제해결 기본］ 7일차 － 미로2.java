import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
 
public class Solution {
     
    static int[][] arr;
    static int start_row;
    static int start_col;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean found;
     
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
 
        for (int t = 0; t < 10; t++) {
 
            int tc = Integer.parseInt(br.readLine().trim());
            arr = new int[100][100];
            boolean[][] visited = new boolean[100][100];
            for(int row=0; row<100; row++) {
                String str = br.readLine();
                for(int col=0; col<100; col++) {
                    arr[row][col] = Integer.parseInt(str.substring(col, col+1));
                    if(arr[row][col] == 2) {
                        start_row = row;
                        start_col = col;
                    }
                }
            }
             
            found = false;
            dfs(start_row, start_col, visited);
             
            if(found) System.out.println("#" + (t+1) + " " + 1);
            else System.out.println("#" + (t+1) + " " + 0);
             
             
        }
    }
     
    public static void dfs(int row, int col, boolean[][] visited) {
        visited[row][col] = true;
         
        if(found == false) {
            for(int i=0; i<4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                 
                if(nr>=0 && nr<100 && nc>=0 && nc<100) {
                    if((arr[nr][nc] == 0 || arr[nr][nc] == 3) && visited[nr][nc] == false) {
                        if(arr[nr][nc] == 3) found = true;
                        dfs(nr, nc, visited);
                        visited[nr][nc] = false;
                    }
                }
            }
        }
         
         
         
    }
}
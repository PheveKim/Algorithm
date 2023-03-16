import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static boolean[] visited;
    static int[][] arr;
    static int n;
    static int m;
    static int target_a;
    static int target_b;
    static int cnt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        target_a = Integer.parseInt(st.nextToken());
        target_b = Integer.parseInt(st.nextToken());
        
        m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = 1;
            arr[to][from] = 1;
        }
         
        cnt = -1;
        bfs();
        System.out.println(cnt);
    }
    
    public static void bfs() {
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {target_a, 0});
        visited[target_a] = true;
        
        while(!q.isEmpty()) {
        	
            int[] popped = q.poll();
            int popped_pos = popped[0];
            int popped_cnt = popped[1];
            if(popped_pos == target_b) {
                cnt = popped_cnt;
                break;
            }
            for(int i=0; i<arr.length; i++) {
                if(visited[i] == false && arr[popped_pos][i] == 1) {
                    q.add(new int[] {i, popped_cnt + 1});
                    visited[i] = true;
                }
            }
        }
    }
}
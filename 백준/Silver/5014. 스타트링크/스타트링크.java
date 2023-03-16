import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static boolean[] visited;
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new boolean[F+1];
		
		cnt = -1;
		bfs();
		if(cnt == -1) System.out.println("use the stairs");
		else System.out.println(cnt);
 		
	}
	
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {S,0});
		visited[S] = true;
		
		while(!q.isEmpty()) {
			int[] popped = q.poll();
			int popped_pos = popped[0];
			int popped_cnt = popped[1];
//			System.out.println(Arrays.toString(visited) + " " + popped_cnt);
			if(popped_pos == G) {
				cnt = popped_cnt;
				break;
			}
			
			if(popped_pos + U <= F && visited[popped_pos + U] == false) {
				q.add(new int[] {popped_pos + U, popped_cnt + 1});
				visited[popped_pos + U] = true;
			}
			if(popped_pos - D >= 1 && visited[popped_pos - D] == false) {
				q.add(new int[] {popped_pos - D, popped_cnt + 1});
				visited[popped_pos - D] = true;
			}
		}
	}
}
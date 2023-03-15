import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int infected_num;
	static boolean[] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		visited = new boolean[N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			list.get(from).add(to);
			list.get(to).add(from);
			
		}
		infected_num = 0;
		bfs(1);
		System.out.println(infected_num);
	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int popped = q.poll();
			for(int i=0; i<list.get(popped).size(); i++) {
				if(visited[list.get(popped).get(i)] == false) {
					q.add(list.get(popped).get(i));
					visited[list.get(popped).get(i)] = true;
					infected_num++;
				}
			}
		}
	}
}
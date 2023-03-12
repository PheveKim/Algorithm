import java.util.*;
import java.io.*;

public class Main {
	static int min;
	static int N;
	static int M;
	static boolean[] visited;
	static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int cycle_cnt;
	static int visit_cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		cycle_cnt = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(map.get(from) == null) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(to);
				map.put(from, temp);
			}
			else {
				map.get(from).add(to); // 이렇게 바로 get 후에 add 해주어도 map 에 반영이 된다.
				//ArrayList<Integer> temp = (ArrayList<Integer>) map.get(from).clone(); // 받아온것 복제해서 추가해서 다시 put 해줄필요없다.
				//temp.add(to);
				//map.put(from, temp);
				// 결과 : 1=[2], 2=[5, 4, 3], 3=[4], 4=[6], 5=[1, 4]
			}
			if(map.get(to) == null) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(from);
				map.put(to, temp);
			}
			else {
				map.get(to).add(from);
			}
		}
		for(int i=1; i<N+1; i++) {
			bfs(i);
		}
		System.out.println(cycle_cnt + N - visit_cnt);
		// visit_cnt 와 N 이 다르다면, N-visit_cnt 만큼의 노드는 연결없이 혼자 존재한다는 의미이므로, 
		// N - visit_cnt 를 더해준다.
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		if(visited[start] == false && map.get(start) != null) {
			q.add(start);
			visited[start] = true;
			visit_cnt++;
			cycle_cnt++;
		}
		while(!q.isEmpty()) {
			int popped = q.poll();
			if(map.get(popped) != null) {
				for(int i=0; i<map.get(popped).size(); i++) {
					if(visited[map.get(popped).get(i)] == false) {
						q.add(map.get(popped).get(i));
						visited[map.get(popped).get(i)] = true;
						visit_cnt++;
					}
				}
			}
		}
	}
}
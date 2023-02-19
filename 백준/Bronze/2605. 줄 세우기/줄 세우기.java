import java.util.*;

import javax.imageio.IIOException;

import java.io.*;
import java.lang.*;

public class Main {

	static int[][] arr;
	static boolean[] visited;
	static int N;
	static int M;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(list.size() - Integer.parseInt(st.nextToken()), (i + 1));
		}

		for (int i = 0; i < N; i++) {
			System.out.print(list.get(i) + " ");
		}

	}

	public static void dfs(int from) {

		visited[from] = true;
		cnt++;

		for (int to = 1; to < N + 1; to++) {
			if (visited[to] == false && arr[from][to] == 1) {
				dfs(to);
			}
		}

	}

	public static void bfs(int from) {

		Queue<Integer> q = new LinkedList<>();
		visited[from] = true;
		cnt++;
		q.add(from);

		while (!q.isEmpty()) {
			int popped_from = q.poll();
			for (int to = 1; to < N + 1; to++) {
				if (visited[to] == false && arr[popped_from][to] == 1) {
					visited[to] = true;
					cnt++;
					q.add(to);
				}
			}
		}

	}

}
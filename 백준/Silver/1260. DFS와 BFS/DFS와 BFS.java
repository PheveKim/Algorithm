import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int m = 0; m < M; m++) {

			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			arr[from][to] = 1;
			arr[to][from] = 1;

		}

		dfs(start);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(start);

	}

	public static void dfs(int from) {

		visited[from] = true;
		System.out.print(from + " ");

		for (int to = 1; to < N + 1; to++) {
			if (arr[from][to] == 1 && visited[to] == false)
				dfs(to);
		}

	}

	public static void bfs(int from) {

		Queue<Integer> q = new LinkedList<>();
		
		visited[from] = true;
		System.out.print(from + " ");
		q.add(from);

		while (!q.isEmpty()) {

			int pop_from = q.poll();

			for (int to = 1; to < N + 1; to++) {
				if (arr[pop_from][to] == 1 && visited[to] == false) {
					visited[to] = true;
					System.out.print(to + " ");
					q.add(to);
				}
			}

		}

	}

}
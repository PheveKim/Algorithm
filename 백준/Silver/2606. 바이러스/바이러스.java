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

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			arr[from][to] = 1;
			arr[to][from] = 1;
		}

		cnt = 0;
		dfs(1);
		System.out.println(cnt-1);

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

}
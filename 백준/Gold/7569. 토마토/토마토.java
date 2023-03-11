import java.util.*;
import java.io.*;

public class Main {
	static int min;
	static int R;
	static int C;
	static int B;
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<int[]> list;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int zero_cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine().trim(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		arr = new int[R * B][C];
		visited = new boolean[R * B][C];
		list = new ArrayList<>();
		zero_cnt = 0;
		for (int row = 0; row < R * B; row++) {
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int col = 0; col < C; col++) {
				arr[row][col] = Integer.parseInt(st.nextToken());
				if (arr[row][col] == 1) {
					list.add(new int[] { row, col, 0 });
				} else if (arr[row][col] == 0) {
					zero_cnt++;
				}
			}
		}
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(min);
	}

	public static void bfs() {

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			q.add(list.get(i));
			visited[list.get(i)[0]][list.get(i)[1]] = true;
		}
		int max_popped_day = 0;
		int cnt = 0;
		while (!q.isEmpty()) {

			int[] popped = q.poll();
			int popped_row = popped[0];
			int popped_col = popped[1];
			int popped_day = popped[2];

			int nr;
			int nc;

			// 해당 층 사방 탐색
			for (int i = 0; i < 4; i++) {
				nr = popped_row + dr[i];
				nc = popped_col + dc[i];
				if (BoundaryCheck(nr, nc) == true) {
					if (visited[nr][nc] == false && arr[nr][nc] == 0) {
						if (popped_row / R == nr / R) {
							q.add(new int[] { nr, nc, popped_day + 1 });
							max_popped_day = Math.max(max_popped_day, popped_day + 1);
							visited[nr][nc] = true;
							cnt++;
						}
					}
				}
			}

			// 아래층, 위층 탐색
			// 현재층 = popped_row / R + poped_row % R;
			// 위층
			nr = (popped_row / R - 1) * R + popped_row % R;
			nc = popped_col;
			if (BoundaryCheck(nr, nc) == true) {
				if (visited[nr][nc] == false && arr[nr][nc] == 0) {
					q.add(new int[] { nr, nc, popped_day + 1 });
					max_popped_day = Math.max(max_popped_day, popped_day + 1);
					visited[nr][nc] = true;
					cnt++;
				}
			}

			// 아래층
			nr = (popped_row / R + 1) * R + popped_row % R;
			nc = popped_col;
			if (BoundaryCheck(nr, nc) == true) {
				if (visited[nr][nc] == false && arr[nr][nc] == 0) {
					q.add(new int[] { nr, nc, popped_day + 1 });
					max_popped_day = Math.max(max_popped_day, popped_day + 1);
					visited[nr][nc] = true;
					cnt++;
				}
			}
		}
		min = Math.min(min, max_popped_day);
		if (zero_cnt != cnt)
			min = -1;

	}

	public static boolean BoundaryCheck(int row, int col) {
		if (row >= 0 && row < R * B && col >= 0 && col < C)
			return true;
		else
			return false;
	}
}
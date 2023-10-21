import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static class Node implements Comparable<Node>{
		int row;
		int col;
		int dis;
		
		public Node(int row, int col, int dis) {
			this.row = row;
			this.col = col;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(Node n2) {
			if(this.dis > n2.dis) return 1;
			return -1;
		}

		@Override
		public String toString() {
			return "Node [row=" + row + ", col=" + col + ", dis=" + dis + "]";
		}
		
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			int[][] dp = new int[N][N];
			boolean[][] visited = new boolean[N][N];
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<N; c++) {
					int dis = Integer.parseInt(Character.toString(str.charAt(c)));
					arr[r][c] = dis;
					dp[r][c] = Integer.MAX_VALUE;
				}
			}
			
			int min = Integer.MAX_VALUE;
			PriorityQueue<Node> q = new PriorityQueue<>();
			q.add(new Node(0,0,arr[0][0]));
			visited[0][0] = true;
			
			while(true) {
				if(q.isEmpty()) break;
				Node node = q.poll();
				if(node.row == N-1 && node.col == N-1) {
					min = node.dis;
					break;
				}
				for(int i=0; i<4; i++) {
					int nr = node.row + dr[i];
					int nc = node.col + dc[i];
					if(!bc(nr,nc,N)) continue;
					if(visited[nr][nc]) continue;
					
					q.add(new Node(nr,nc,node.dis + arr[nr][nc]));
					visited[nr][nc] = true;
				}
			}
			System.out.println("#" + (t+1) + " " + min);
		}
	}
	static boolean bc(int row, int col, int N) {
		if(row>=0 && row<N && col>=0 && col<N) return true;
		return false;
	}
	static void printarr(int[][] arr) {
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[0].length; c++) {
				System.out.print(arr[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
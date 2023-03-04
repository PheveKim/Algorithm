import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static int[] color = {1,2,3};
	static int R;
	static int C;
	static String[][] arr;
	static int min;
	static int change_cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new String[R][C];
			
			for(int row=0; row<R; row++) {
				String str = br.readLine();
				for(int col=0; col<C; col++) {
					arr[row][col] = str.substring(col, col+1);
				}
			}
			
			change_cnt = 0;
			for(int col=0; col<C; col++) {
				if(!arr[0][col].equals("W")) {
					change_cnt++;
				}
			}
			for(int col=0; col<C; col++) {
				if(!arr[R-1][col].equals("R")) {
					change_cnt++;
				}
			}
			
			
			
			int[] chosen = new int[R-2];
			min = Integer.MAX_VALUE;
			choose(0, 0, chosen);
			
			bw.write("#" + (t+1) + " " + min);
			bw.newLine();
			bw.flush();
			
		}
		
	}
	
	
	public static void choose(int cnt, int last_idx, int[] chosen) {
		
		if(cnt >= R-3) {
			
			chosen[R-3] = 2;
			Arrays.sort(chosen);
			
			// {1,2,3,3};
			int need_cnt = 0;
			for(int row=1; row<R-1; row++) {
				String color;
				if(chosen[row-1] == 1) color = "W";
				else if(chosen[row-1] == 2) color = "B";
				else color = "R";
				
				for(int col=0; col<C; col++) {
					if(!arr[row][col].equals(color)) need_cnt++;
				}
			}
			
			min = Math.min(min, change_cnt + need_cnt);
		}
		
		else {
			for(int i=last_idx; i<3; i++) {
//				System.out.println(Arrays.toString(chosen));
				chosen[cnt] = color[i];
				choose(cnt+1, i, chosen);
				chosen[cnt] = 0;
				
				
			}
		}
	}
}
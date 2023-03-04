import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static int N;
	static int Cal_limit;
	static int[] point;
	static int[] cal;
	static int max_point;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int t=0; t<T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Cal_limit = Integer.parseInt(st.nextToken());
			
			point = new int[N];
			cal = new int[N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				point[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			max_point = Integer.MIN_VALUE;
			choose(0, 0, 0);
			
			System.out.println("#" + (t+1) + " " + max_point);
		}
	}
	
	
	// 100 300 240 500  400
	// 200 500 300 1000 400
	public static void choose(int last_idx, int point_sum, int cal_sum) {
		
		max_point = Math.max(max_point, point_sum);
		
		for(int i=last_idx; i<N; i++) {
			if(cal_sum + cal[i] <= Cal_limit) {
				choose(i + 1, point_sum + point[i], cal_sum + cal[i]);
			}
		}
	}
}
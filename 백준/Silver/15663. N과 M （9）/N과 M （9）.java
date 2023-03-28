import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static int[] arr_num;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i=0; i<n; i++) {
			if(map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			}
			else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}
		int[] arr_cnt = new int[map.size()];
		arr_num = new int[map.size()];
		int idx = 0;
		for(int key: map.keySet()) {
			arr_cnt[idx] = map.get(key);
			arr_num[idx] = key;
			idx++;
		}
		dfs(0, new int[m], arr_cnt);
		System.out.println(sb);
	}
	public static void dfs(int cnt, int[] chosen, int[] arr_cnt) {
		if(cnt >= m) {
			for(int i=0; i<m; i++) {
				sb.append(chosen[i] + " ");
			}
			sb.append("\n");
		}
		else {
			for(int i=0; i<arr_cnt.length; i++) {
				if(arr_cnt[i] > 0) {
					chosen[cnt] = arr_num[i];
					arr_cnt[i]--;
					dfs(cnt+1, chosen, arr_cnt);
					arr_cnt[i]++;
					chosen[cnt] = 0;
				}
			}
		}
	}
}
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[] arr2 = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		HashMap<Integer, Integer> dp_map = new HashMap<>();
		dp_map.put(arr[0], 1);
		for(int i=1; i<n; i++) {
			ArrayList<Integer> list_to_add = new ArrayList<>();
			for(int key : dp_map.keySet()) {
				list_to_add.add(Math.abs(key + arr[i]));
				list_to_add.add(Math.abs(key - arr[i]));
			}
			for(int j=0; j<list_to_add.size(); j++) {
				dp_map.put(list_to_add.get(j), 1);
			}
			dp_map.put(arr[i], 1);
		}
		for(int i=0; i<arr2.length; i++) {
			if(dp_map.get(arr2[i]) != null) {
				System.out.print("Y ");
			}
			else {
				System.out.print("N ");
			}
		}
	}
}
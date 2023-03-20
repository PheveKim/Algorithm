import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
	static int N;
	static int K;
	static String str;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			str = br.readLine();
		
			// 회전횟수 = N / 4;
			HashMap<String, Integer> map = new HashMap<>();
			for(int i=0; i<N/4; i++) {
				for(int j=0; j<4; j++) {
					map.put(str.substring(j*(N/4), (j+1)*(N/4)), 1);
				}
				str = str.substring(str.length()-1, str.length()) + str.substring(0, str.length()-1);
			}
			for(String key: map.keySet()) {
				String got = key;
				int sum = 0;
				for(int i=got.length()-1; i>=0; i--) {
					String alpha = "ABCDEF";
					int[] num = {10,11,12,13,14,15};
					String target = got.substring(i, i+1);
					boolean alpha_done = false;
					for(int j=0; j<alpha.length(); j++) {
						if(target.equals(alpha.substring(j,j+1))) {
							alpha_done = true;
							sum += num[j] * Math.pow(16, got.length() - i - 1);
						}
					}
					if(alpha_done == false) {
						sum += Integer.parseInt(target) * Math.pow(16, got.length() - i - 1);
					}
					
				}
				map.put(key, sum);
			}
			ArrayList<String> list = new ArrayList<>(map.keySet());
			list.sort((o1,o2) -> map.get(o2).compareTo(map.get(o1)));
			System.out.println("#" + (t+1) + " " + map.get(list.get(K-1)));
		}
	}
}
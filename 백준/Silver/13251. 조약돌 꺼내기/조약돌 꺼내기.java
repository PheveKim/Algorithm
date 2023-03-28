import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int m = Integer.parseInt(br.readLine());
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		
		// 분모 = arr_sum C k
		// 분자 = arr_sum[0] C k + arr_sum[1] C k + ...
		
		double arr_sum = 0;
		double temp_sum = 0;
		for(int i=0; i<m; i++) {
			arr_sum += arr[i];
			if(arr[i] >= k) {
				double temp_mul = 1;
				for(int j=0; j<k; j++) {
					temp_mul *= arr[i] - j;
				}
				temp_sum += temp_mul;
			}
		}
		double bottom = 1;
		for(int j=0; j<k; j++) {
			bottom *= arr_sum - j;
		}
		System.out.println(temp_sum / bottom);
	}
}
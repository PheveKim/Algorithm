import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Solution {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] arr;
	static int max;
	static int min;
	static int N;
	static String[] symbol = { "+", "-", "*", "/" };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			ArrayList<String> list_operator = new ArrayList<>();
			int[] OP = new int[4];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				OP[i] = Integer.parseInt(st.nextToken());	
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			//operator(list_operator, "");
			Do(arr[0], 0, OP[0], OP[1], OP[2], OP[3]);
			
			System.out.println("#" + (t + 1) + " " + (max-min));
		}

	}

	public static void operator(ArrayList<String> list_operator, String result) {

		if (list_operator.size() == 0) {
			
			int real_result = arr[0];
			for(int i=0; i<N-1; i++) {
				String op = result.substring(i, i+1);
				if(op.equals("+")) real_result += arr[i+1];
				else if(op.equals("-")) real_result -= arr[i+1];
				else if(op.equals("*")) real_result *= arr[i+1];
				else if(op.equals("/")) real_result /= arr[i+1];
			}
			
			max = Math.max(max, real_result);
			min = Math.min(min, real_result);
		}

		else {

			for (int i = 0; i < list_operator.size(); i++) {
				result += list_operator.get(i);
				String removed_target = list_operator.get(i);
				list_operator.remove(i);
				operator(list_operator, result);
				list_operator.add(i, removed_target);
				result = result.substring(0, result.length() - 1);
			}

		}

	}

	public static void Do(int result, int cnt, int add_cnt, int sub_cnt, int mul_cnt, int div_cnt) {
		
		cnt++;
		if(cnt == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
		}
		
		else {
			
			if(add_cnt>0) {
				Do(result+arr[cnt], cnt, add_cnt-1, sub_cnt, mul_cnt, div_cnt);
			}
			if(sub_cnt>0) {
				Do(result-arr[cnt], cnt, add_cnt, sub_cnt-1, mul_cnt, div_cnt);
			}
			if(mul_cnt>0) {
				Do(result*arr[cnt], cnt, add_cnt, sub_cnt, mul_cnt-1, div_cnt);
			}
			if(div_cnt>0) {
				Do(result/arr[cnt], cnt, add_cnt, sub_cnt, mul_cnt, div_cnt-1);
			}
			
		}
		
	}
	
}
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		arr = new int[8];
		st = new StringTokenizer(br.readLine());
		int up_cnt = 0;
		int down_cnt = 0;
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<8; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i-1] < arr[i]) {
				up_cnt++;
			}
			else if(arr[i-1] > arr[i]) {
				down_cnt++;
			}
			if(up_cnt > 0 && down_cnt > 0) {
				System.out.println("mixed");
				break;
			}
			else if(up_cnt == 7 && down_cnt == 0) {
				System.out.println("ascending");
				break;
			}
			else if(down_cnt == 7 && up_cnt == 0) {
				System.out.println("descending");
				break;
			}
		}
	}
}
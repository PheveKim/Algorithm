import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		int[] pick = new int[M];
		
		choose_list(N, M, 0, list, 0);
//		choose_arr(N, M, 0, pick, 0);
		bw.flush();
	}
	
	// 리스트 add, remove를 이용한 풀이
	public static void choose_list(int N, int M, int cnt, ArrayList<Integer> list, int last_idx) throws IOException {
		if(cnt >= M) {
			for(int i=0; i<list.size(); i++) {
				bw.write(list.get(i) + " ");
			}
			bw.newLine();
		}
		else {
			for(int i=last_idx; i<N; i++) {
				list.add(i+1);
				choose_list(N, M, cnt+1, list, i);
				list.remove(list.size()-1);
			}
		}
	}
	
	// 배열 인덱스를 이용한 풀이
	public static void choose_arr(int N, int M, int cnt, int[] pick, int last_idx) throws IOException {
		if(cnt >= M) {
			for(int i=0; i<pick.length; i++) {
				bw.write(pick[i] + " ");
			}
			bw.newLine();
		}
		else {
			for(int i=last_idx; i<N; i++) {
				pick[cnt] = i+1;
				choose_arr(N, M, cnt+1, pick, i);
				pick[cnt] = 0;
			}
		}
	}
}
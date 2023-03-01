import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int o;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		int[] pick = new int[M];
		
		choose_list(N, M, 0, list);
//		choose_arr(N, M, 0, pick);
		bw.flush();
	}
	
	// 리스트 add, remove를 이용한 풀이
	public static void choose_list(int N, int M, int cnt, ArrayList<Integer> list) throws IOException {
		o++;
		if(cnt >= M) {
			for(int i=0; i<list.size(); i++) {
				bw.write(list.get(i) + " ");
			}
			bw.newLine();
		}
		
		else {
			for(int i=1; i<N+1; i++) {
				list.add(i);
				choose_list(N, M, cnt+1, list);
				list.remove(list.size()-1);
			}
		}
				
		cnt++;
	}
	
	// 배열 인덱스를 이용한 풀이
	public static void choose_arr(int N, int M, int cnt, int[] pick) throws IOException {
		o++;
		if(cnt >= M) {
			for(int i=0; i<pick.length; i++) {
				bw.write(pick[i] + " ");
			}
			bw.newLine();
		}
		
		else {
			for(int i=1; i<N+1; i++) {
				pick[cnt] = i;
				choose_arr(N, M, cnt+1, pick);
				pick[cnt] = 0; // 백트래킹 해줘도 되고 안해줘도 되고.
			}
		}
				
		cnt++;
	}
	
}
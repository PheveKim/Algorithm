import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		
		int[] arr = new int[N];
		int[] cnt = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		cnt[0] = 1;
		
		int throw_cnt = 0;
		int got = 0;
		while(true) {
			if(cnt[got] == M) break;
			throw_cnt++;
			
			if(cnt[got] % 2 == 0) {
				got = got - L;
				if(got < 0) got = got + N;
				cnt[got]++;
			}
			else {
				got = got + L;
				if(got >= N) got = got - N;
				cnt[got]++;
			}
		}
		System.out.println(throw_cnt);
	}
}
import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			q.add(i+1);
		}
		
		int cnt = 0;
		while(true) {
			if(q.isEmpty()) break;
			int popped = q.poll();
			cnt++;
			if(cnt == K) {
				list.add(popped);
				cnt = 0;
			}
			else {
				q.add(popped);
			}
		}
		System.out.print("<");
		for(int i=0; i<list.size(); i++) {
			if(i==list.size()-1) System.out.print(list.get(i));
			else System.out.print(list.get(i) + ", ");
		}
		System.out.print(">");
		
	}
}
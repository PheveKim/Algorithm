import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        

		int T = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<T; i++) {
			
			HashMap<Integer, Integer> map = new HashMap<>();
			
			int N = Integer.parseInt(br.readLine());
			
			for(int j=0; j<N; j++) {
				
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				for(int k=A; k<B+1; k++) {
					if(map.get(k) != null) map.put(k, map.get(k)+1);
					else map.put(k, 1);
				}
			}
			
			
			int P = Integer.parseInt(br.readLine());
			
			System.out.print("#" + (i+1) + " ");
			for(int j=0; j<P; j++) {
				int C = Integer.parseInt(br.readLine());
				if(map.get(C) != null) System.out.print(map.get(C) + " ");
				else System.out.print(0 + " ");
			}
			System.out.println();
		}
		
		br.close();
		bw.close();
		
		
		
		
		

	}

}
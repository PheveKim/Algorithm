import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	static int n;
	static int m;
	static BigInteger cnt_all;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
        	st = new StringTokenizer(br.readLine());
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	cnt_all = BigInteger.ONE;
        	
        	// m 개중에 n개를 뽑는 조합
        	// mCn
        	for(int i=0; i<n; i++) {
        		cnt_all = cnt_all.multiply(new BigInteger(Integer.toString(m-i)));
        	}
        	for(int i=0; i<n; i++) {
        		cnt_all = cnt_all.divide(new BigInteger(Integer.toString(i+1)));
        	}
        	System.out.println(cnt_all);
        }
    }
}
import java.util.Scanner;

public class Main {
	static double[][] dp= new double[101][101];
	static StringBuilder sb= new StringBuilder(); 
	
	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		
		//N은 a개수, M은 z개수, K번째 문자열을 구해야함.
		//N, M은 100이하, K는 10억 이하의 수
		int N= scan.nextInt();
		int M= scan.nextInt();
		double K= scan.nextDouble();
		
		if(check(N, M)<K) {
			System.out.println("-1");
		}else {
			makeS(N, M, K);
			System.out.println(sb.toString());
		}
	}//main
	
	//개수 구하는 함수
	public static double check(int a, int z) {
		if(a==0||z==0) return 1;
		if(dp[a][z]!=0) return dp[a][z];
		
		return dp[a][z]= Double.min(check(a-1, z)+check(a, z-1), 1000000001);
	}
	
	//문자열 만드는 함수
	public static void makeS(int a, int z, double k) {
		if(a==0) {
			for(int i=0; i<z; i++)
				sb.append("z");
			return;
		}
		if(z==0) {
			for(int i=0; i<a; i++)
				sb.append("a");
			return;
		}
		
		double check= check(a-1, z);
		if(k>check) {
			sb.append("z");
			makeS(a, z-1, k-check);
		}else {
			sb.append("a");
			makeS(a-1, z, k);
		}
	}//makeS	
}
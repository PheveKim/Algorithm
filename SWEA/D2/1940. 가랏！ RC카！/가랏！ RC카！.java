import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int N = sc.nextInt();

			int current_velo = 0;
			int velo = 0;
			;
			int change;
			int dist = 0;
			for (int n = 0; n < N; n++) {
				change = sc.nextInt();
				if (change != 0) {
					velo = sc.nextInt();
				}
				if (change == 1) {
					current_velo += velo;
					dist += current_velo;
				} else if (change == 2) {
					if (current_velo < velo)
						current_velo = 0;
					else
						current_velo -= velo;
					dist += current_velo;
				} else {
					dist += current_velo;
				}
			}

			System.out.println("#" + (t + 1) + " " + dist);
		}
	}
}
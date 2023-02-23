import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
 
public class Solution {
 
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int min;
    static int N;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
 
            st = new StringTokenizer(br.readLine(), " ");
            int st_len = st.countTokens();
            double sum = 0;
            for (int i = 0; i < st_len; i++) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
            }
            int avg = (int) Math.round(sum/st_len);
            System.out.println("#" + (t + 1) + " " + avg);
 
        }
 
    }
 
}
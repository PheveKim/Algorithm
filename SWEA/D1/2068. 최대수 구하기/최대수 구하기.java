import java.util.*;
import java.io.*;
import java.lang.*;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
 
        for (int t = 0; t < T; t++) {
 
            st = new StringTokenizer(br.readLine());
            int max = 0;
            for (int i = 0; i < 10; i++)
                max = Math.max(max, Integer.parseInt(st.nextToken()));
 
            bw.write("#" + (t + 1) + " " + max);
            bw.newLine();
            bw.flush();
 
        }
 
    }
 
}
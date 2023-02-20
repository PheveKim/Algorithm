import java.util.*;
import java.io.*;
import java.lang.*;
 
public class Solution {
 
    static int dr[] = { -1, 1, 0, 0 };
    static int dc[] = { 0, 0, -1, 1 };
    static int N;
    static int[][] arr;
    static int max;
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
 
            String[][] arr = new String[15][15];
 
            for (int i = 0; i < 5; i++) {
                String str = br.readLine();
 
                for (int j = 0; j < str.length(); j++) {
                    arr[i][j] = str.substring(j, j + 1);
                }
 
            }
 
            String answer = "";
            for (int j = 0; j < 15; j++) {
                for (int i = 0; i < 5; i++) {
                    if (arr[i][j] != null)
                        answer += arr[i][j];
                }
            }
 
            System.out.println("#" + (t + 1) + " " + answer);
        }
 
    }
 
}
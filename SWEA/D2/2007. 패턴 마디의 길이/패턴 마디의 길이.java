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
 
            String input = br.readLine();
            HashMap<String, Integer> map = new HashMap<>();
 
            String target = "";
            int cnt = 0;
            for (int i = 0; i < input.length(); i++) {
 
                target += input.substring(i, i + 1);
                if (target.length() >= 2) {
                    if (target.substring(0, target.length() / 2)
                            .equals(target.substring(target.length() / 2, target.length()))) {
                        cnt = target.length() / 2;
                        break;
                    }
 
                }
 
            }
 
            System.out.println("#" + (t + 1) + " " + cnt);
        }
 
    }
 
    public static void function(int n) {
 
    }
 
}
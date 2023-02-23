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
 
        String al = "abcdefghijklmnopqrstuvwxyz";
        String al_big = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str = br.readLine();
 
        System.out.print(str.substring(0, 1));
 
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("_") || str.substring(i, i + 1).equals(".")) {
                System.out.print(str.substring(i, i + 1));
                continue;
            }
            for (int j = 0; j < al.length(); j++) {
                if (str.substring(i, i + 1).equals(al.substring(j, j + 1))) {
                    System.out.print(al_big.substring(j, j + 1));
                    break;
                }
            }
        }
 
    }
 
}
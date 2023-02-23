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
 
            String str = br.readLine();
 
            String year = str.substring(0, 4);
            String month = str.substring(4, 6);
            String day = str.substring(6, 8);
 
            boolean valid = true;
 
            int year_int = Integer.parseInt(year);
            int month_int = Integer.parseInt(month);
            int day_int = Integer.parseInt(day);
 
            if (year_int == 0 || month_int == 0 || day_int == 0)
                valid = false;
 
            if (month_int > 12 || day_int > 31)
                valid = false;
 
            if (month_int == 2 && day_int > 28)
                valid = false;
            if (month_int == 4 && day_int == 31)
                valid = false;
            if (month_int == 6 && day_int == 31)
                valid = false;
            if (month_int == 9 && day_int == 31)
                valid = false;
            if (month_int == 11 && day_int == 31)
                valid = false;
 
            String answer = "";
            if (valid) {
                answer = year + "/" + month + "/" + day;
            } else {
                answer = "-1";
            }
 
            System.out.println("#" + (t + 1) + " " + answer);
        }
 
    }
 
}
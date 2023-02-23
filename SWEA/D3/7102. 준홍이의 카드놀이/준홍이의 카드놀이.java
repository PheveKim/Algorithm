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
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
 
            int cnt = 0;
            int sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int n = 1; n < N + 1; n++) {
                for (int m = 1; m < M + 1; m++) {
                    sum = n + m;
                    if (map.get(sum) == null) {
                        map.put(sum, 1);
                    } else {
                        map.put(sum, map.get(sum) + 1);
                    }
                }
            }
 
            ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
            keyList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
 
            int max_idx = keyList.get(0);
            int max_cnt = map.get(keyList.get(0));
            System.out.print("#" + (t + 1) + " ");
            System.out.print(max_idx + " ");
            for (int i = 1; i < keyList.size(); i++) {
                int current_idx = keyList.get(i);
                int current_cnt = map.get(keyList.get(i));
                if (current_cnt == max_cnt) {
                    System.out.print(current_idx + " ");
                }
            }
            System.out.println();
 
        }
 
    }
 
}
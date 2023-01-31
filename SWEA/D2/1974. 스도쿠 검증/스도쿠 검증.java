import java.util.*;
import java.io.*;
import java.lang.*;
 
public class Solution {
     
    public static void main(String[] args) {
         
         
        Scanner scanner = new Scanner(System.in);
         
        int N = scanner.nextInt();
        int[][] arr = new int [9][9];
         
        for(int i=0; i<N; i++) {
             
            for(int row=0; row<9; row++) {
                for(int col=0; col<9; col++) {
                    int num = scanner.nextInt();
                    arr[row][col] = num;
                }
            }
             
             
            int is_true = 1;
             
            //row 탐색
            for(int row=0; row<9; row++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                 
                for(int col=0; col<9; col++) {
                 
                    if(map.get(arr[row][col]) != null) {
                        is_true = 0;
                        break;
                    }
                    map.put(arr[row][col], 1);
                }
            }
             
            //col 탐색
            if(is_true == 1) {
                for(int col=0; col<9; col++) {
                    HashMap<Integer, Integer> map = new HashMap<>();
                     
                    for(int row=0; row<9; row++) {
                     
                        if(map.get(arr[row][col]) != null) {
                            is_true = 0;
                            break;
                        }
                        map.put(arr[row][col], 1);
                    }
                }
            }
             
            //3*3 탐색
            if(is_true == 1) {
                 
 
                int[][] arr3 = new int[3][3];
                int cnt = 0;
                HashMap<Integer, Integer> map = new HashMap<>();
                 
                Loop1 : for(int k=0; k<3; k++) {
                     
                    for(int col=0; col<9; col++) {
                        if(cnt == 3) {
                            map = new HashMap<>();
                            cnt = 0;
                        }
                        for(int row=3*k; row<3*k+3; row++) {
                            if(map.get(arr[row][col]) != null) {
                                is_true = 0;
                                break Loop1;
                            }
                            map.put(arr[row][col], 1);          
                        }
                        cnt++;
                    }
                }
                 
            }
             
             
             
            System.out.println("#" + (i+1) + " " + is_true);
        }
         
         
         
    }
     
}
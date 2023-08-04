import java.util.*;
import java.math.*;
import java.io.*;
import java.lang.*;

public class Solution {
	static int NODE_MAX = 5000;
	
	static class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	static class LL {
		Node head;
		Node tail;
		Node[] nodeArr;
		int nodeCnt;
		
		public LL() {
			head = null;
			nodeArr = new Node[NODE_MAX];
			nodeCnt = 0;
		}
		
		Node getNewNode(int data) {
			nodeArr[nodeCnt] = new Node(data);
			return nodeArr[nodeCnt++];
		}
		
		void insert(int idx, int[] nums) {
			int st = 0;
			if(idx == 0) {
				if(head != null) {
					Node new_head = getNewNode(nums[0]);
					new_head.next = head;
					head = new_head;
				}
				
				else {
					head = getNewNode(nums[0]);
				}
				idx = 1;
				st = 1;
			}

			Node cur = head; // head 에서 출발
			
			for(int i=1; i<idx; i++) {
				cur = cur.next;
			}
			
			for(int i=st; i<nums.length; i++) {
				Node newNode = getNewNode(nums[i]);
				newNode.next = cur.next;
				cur.next = newNode;
				cur = newNode;
			}
			
			if(cur.next == null) {
				tail = cur;
			}
			
		}
		
		
		void delete(int idx, int y) {
			Node cur = head;
			if(idx == 0) {
				for(int i=0; i<y; i++) {
					cur = cur.next;
				}
				head = cur;
				return;
			}
			
			else {
				
				for(int i=1; i<idx; i++) {
					cur = cur.next;
				}
				
				Node start = cur;
				for(int i=0; i<y; i++) {
					cur = cur.next;
				}
				start.next = cur.next;
				if(start.next == null) {
					tail = start;
				}
				
			}
			
		}
		
		
		void addtail(int[] nums) {
			// tail 에다가 nums 붙이기.
			for(int i=0; i<nums.length; i++) {
				Node newNode = getNewNode(nums[i]);
				tail.next = newNode;
				tail = newNode;
			}
		}
		
		void print() {
			Node cur = head;
			for(int i=0; i<10; i++) {
				System.out.print(cur.data + " ");
				cur = cur.next;
			}
		}
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		int T = 10;
		
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			LL list = new LL();
			list.insert(0, arr);
			
			int M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				char cmd = st.nextToken().charAt(0);
				if(cmd == 'I') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					int[] input = new int[y];
					for(int j=0; j<y; j++) {
						input[j] = Integer.parseInt(st.nextToken());
					}
					list.insert(x, input);
				}
				else if (cmd == 'D') {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					list.delete(x, y);
				}
				else if (cmd =='A') {
					int y = Integer.parseInt(st.nextToken());
					int[] input = new int[y];
					for(int j=0; j<y; j++) {
						input[j] = Integer.parseInt(st.nextToken());
					}
					list.addtail(input);
				}
			}
			
			System.out.print("#" + (t+1) + " ");
			list.print();
			System.out.println();
		}
		
	}
}
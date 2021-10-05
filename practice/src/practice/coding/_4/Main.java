package practice.coding._4;

import java.io.*;
import java.util.*;

public class Main {
	//배열
	public static int[] arr;
	//입력받을 값
	public static int n;
	public static int m;	
	//결과값
	public static int count = 0;
	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//n*n의 크기의 체스판에서 m개의 룩이 존재할수있는 경우의 수
		//같은줄에는 존재할수 없다.
		//n*n-1(n-m)*n-2(m-
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		queen(0);
		
		System.out.println(count);
		
		
	}	
	//백트랙킹할 함수
	public static void queen(int depth,int a) {
		//끝까지 왔다는거는 다 채운거니까 수 ++ return
		if (depth == n||a == m) {
			count++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			arr[depth]=i;
			//이자리에 넣을수있는지 확인하고 넣을수 있으면 depth++한걸 불러온다.
			if(possible(depth)) {
				queen(depth+1,a+1);
			}
		}
	}
	
	public static boolean possible(int col) {
		for(int i=0;i<col;i++) {
			//행이 일치할 경우
			if(arr[col]==arr[i]) {
				return false;
			}
		}
		return true;
	}
}
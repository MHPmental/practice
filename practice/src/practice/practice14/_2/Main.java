package practice.practice14._2;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static int n,m;

	public static void main(String[] args) throws IOException {
		//n m 수열 구하기
		//오름차순 만 정렬
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		
		arr = new int[m];
		
		
		dfs(1,0);		
		
		
	}	
	public static void dfs(int a, int depth) {
		if (depth == m) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
 
		for (int i = a; i <= n; i++) {
			arr[depth]=i;
			dfs(i+1,depth+1);
		}
	}
}
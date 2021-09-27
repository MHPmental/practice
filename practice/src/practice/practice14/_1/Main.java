package practice.practice14._1;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		//n m 수열 구하기
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());

		
		arr = new int[m];
		
		visit = new boolean[n];
		
		dfs(n,m,0);		
		
		
	}	
	public static void dfs(int N, int M, int depth) {
		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
 
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i + 1;
				dfs(N, M, depth + 1);
				visit[i] = false;
			}
		}
	}
}
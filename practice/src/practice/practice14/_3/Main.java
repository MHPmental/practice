package practice.practice14._3;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static int n,m;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//n m 수열 구하기
		//중복 다 포함하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		
		arr = new int[m];
		
		
		dfs(0);		
		System.out.println(sb);
		
		
	}	
	public static void dfs(int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append('\n');
			return;
		}
 
		for (int i = 1; i <= n; i++) {
			arr[depth]=i;
			dfs(depth+1);
		}
	}
}
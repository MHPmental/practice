package practice.practice14._4;

import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static int n,m;
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//n m 수열 구하기
		//중복 다 포함하기
		//뒤에는 자기보다 큰것만 나오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());

		m = Integer.parseInt(st.nextToken());

		
		arr = new int[m];
		
		
		dfs(1,0);		
		System.out.println(sb);
		
		
	}	
	public static void dfs(int a,int depth) {
		if (depth == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append('\n');
			return;
		}
 
		for (int i = a; i <= n; i++) {
			arr[depth]=i;
			dfs(i,depth+1);
		}
	}
}
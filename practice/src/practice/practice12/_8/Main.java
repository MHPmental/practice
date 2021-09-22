package practice.practice12._8;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//글자를 입력받아서 길이순 정렬
		//[][] 해서 글자랑 글자수 정렬을 한뒤에 글자수로 정렬을 하면서 글자수가 같으면 사전순으로..
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][2];
		
		StringTokenizer st;
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (a1,a2) -> {
			if(a1[1]==a2[1]) {
				return a1[0]-a2[0];
			}else {
				return a1[1]-a2[1];
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i <n ;i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}	
}
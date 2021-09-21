package practice.practice12._6;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//입력받은 좌표를 정렬하기 
		//x가 1번째로 비교 x가 같으면 y를 비교
		
		
		
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
			if(a1[0]==a2[0]) {
				return a1[1]-a2[1];
			}else {
				return a1[0]-a2[0];
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i <n ;i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}	
}
package practice.practice12._9;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//글자를 입력받아서 길이순 정렬
		//입력받아서 나이순 정렬 후 가입순 정렬
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		String[][] arr = new String[n][2];
		
		StringTokenizer st;
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		
		Arrays.sort(arr,new Comparator<String[]>() {
			@Override
			public int compare(String[] a1,String[] a2) {
				return Integer.parseInt(a1[0]) - Integer.parseInt(a2[0]);
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i <n ;i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
		}
		System.out.println(sb);
	}	
}
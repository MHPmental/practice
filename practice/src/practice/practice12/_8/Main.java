package practice.practice12._8;

import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		//글자를 입력받아서 길이순 정렬
		//글자수 정렬을 한뒤에 글자수로 정렬을 하면서 글자수가 같으면 사전순으로..
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		//글자수 정렬하고
		String[] arr = new String[n];
		
		
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr,new Comparator<String>() {
			public int compare(String a1,String a2) {
				if(a1.length()==a2.length()) {
					return a1.compareTo(a2);
				}else {
					return a1.length() - a2.length();
				}
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		//여러개의 단어는 한번만 출력
		sb.append(arr[0]).append('\n');
		for(int i = 1;i <n ;i++) {
			if(!arr[i].equals(arr[i-1])) sb.append(arr[i]).append('\n');
		}
		
		System.out.println(sb);
	}	
}
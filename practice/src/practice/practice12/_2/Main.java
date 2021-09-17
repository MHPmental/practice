package practice.practice12._2;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//수 정렬하기
		//함수 사용해보기
		//
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(int num : list) {
			sb.append(num).append('\n');
		}
		System.out.println(sb);
	}	
}
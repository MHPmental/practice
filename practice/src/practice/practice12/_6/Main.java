package practice.practice12._6;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//입력받은 좌표를 정렬하기 
		//x가 1번째로 비교 x가 같으면 y를 비교
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n.length(); i++) {
			list.add(Character.getNumericValue(n.charAt(i)));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = n.length()-1;i>=0;i--) {
			sb.append(list.get(i));
		}
		System.out.println(sb);
	}	
}
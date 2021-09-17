package practice.practice12._3;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//수 정렬하기
		//카운팅정렬로 해보자
		//중복되는 수가 입력된다.
		//수의 범위는 지정되어있다.
		//1~10000까지
		//
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		//0~100000 까지 입력받기 위한 arr
		int[] arr = new int[10001];
		//각 수가 들어오면 그 수의 위치에 +1
		for(int i = 0; i < n; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		
		//
		
		StringBuilder sb = new StringBuilder();
		//1~10000까지 순서대로 출력
		for(int i=1;i<10001;i++) {
			//수가 0보다 크면 그만큼 출력을 한다.
			while(arr[i]>0) {
				sb.append(i).append('\n');
				arr[i]--;
			}
			
		}
		System.out.println(sb);
	}	
}
package practice.practice12._3;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		//수 처리하기
		//첫줄에는 입력받을 수 갯수
		//다음부터는 수입력을 받아서
		//1. 산술 평균 내기 > 그냥 더해서 /n
		//2. 중앙값 = 순서로 나열했을 경우 그 중앙에 위치하는 값 > Sort 사용하고 n/2 index에 위치한 값
		//3. 최빈값 = 가장 많이 나온값 > 카운팅 정렬?
		//4. 범위 = 최댓값 - 최솟값 > 

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		//0~40000 까지 입력받기 위한 arr
		int[] arr = new int[8001];
		int[] arr2 = new int[n];
		int sum = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		//각 수가 들어오면 그 수의 위치에 +1
		for(int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			sum += x;
			arr[x+4000]++;
			arr2[i] = x;
			if(max < x) {
				max = x;
			}
			if(min > x) {
				min = x;
			}
			
		}
		Arrays.sort(arr2);
		StringBuilder sb = new StringBuilder();
		//1.평균내기
		sb.append((int)Math.round((double)sum/n)).append('\n');
		//System.out.println(sum/n);
		//2. 중앙값 출력
		sb.append(arr2[n/2]).append('\n');
		//System.out.println(arr2[n/2]);
		//3. 최빈값
		int y = 5000;
		int cnt = 0;
		boolean ddd = false;
		//-4000~4000까지 순서대로 출력
		for(int i=min+4000;i<=max+4000;i++) {
			if(arr[i]!=0) {
				if(cnt<arr[i]) {
					cnt = arr[i];
					y = i-4000;
					ddd = true;
				}else if(cnt == arr[i]&&ddd==true) {
					y = i-4000;
					ddd = false;
				}
			}
		}
		sb.append(y).append('\n');
		sb.append(max-min);
		System.out.println(sb);
	}	
}
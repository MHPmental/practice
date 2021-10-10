package practice.practice15._14;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] arr;
	static int[] arr2;
	
	public static void main(String[] args) throws IOException {
		//가장 긴 증가하는 부분 수열
		//수열 A가 주어졌을때 가장 긴 증가하는 부분 수열을 구하는 프로그램
		//dd
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr = new int[n];
		arr2 = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			arr2[i] = -1;
		}
		
		for(int i =0;i<n;i++) {
			longNum(i);
		}
		
		int max = arr2[0];
		
		for(int i=1;i<n;i++) {
			max = Math.max(max, arr2[i]);
		}
		
		System.out.println(max);
		
	}
	
	public static int longNum(int a) {
		if(arr2[a]==-1) {
			arr2[a] =1;
			
			for(int i = a-1; i>=0;i--) {
				if(arr[i]<arr[a]) {
					arr2[a] = Math.max(arr2[a], longNum(i)+1);
				}
			}
			
		}
		return arr2[a];
	}
	public static void longNum2(int a) {
		for (int i = 0; i < a; i++) {
			arr2[i]=1;
			for(int j=0; j<i;j++) {
				if(arr[i]>arr[j]&&arr2[i]<arr2[j]+1) {
					arr2[i] = arr2[j]+1;
				}
			}
		}
	}
	
}
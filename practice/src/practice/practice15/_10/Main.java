package practice.practice15._10;

import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int[] arr2;
	
	public static void main(String[] args) throws IOException {
		//포도주를 야무지게 먹어야지~
		//포도주잔을 선택하면 그잔에 들어있는 거는 모두 마셔야하고, 연속으로 3잔을 마실수는 없다.
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		arr2 = new int[n+1];
		for(int i=1;i<=n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			arr2[i] = -1;
		}
		
		arr2[1]=arr[1];
		
		if(n>1) {
			arr2[2] = arr[1]+arr[2];
		}
		wine2(n);
		System.out.println(arr2[n]);
		
	}
	
	public static int wine(int a) {
		if(arr2[a]==-1) {
			arr2[a] = Math.max(Math.max(wine(a-2),wine(a-3)+arr[a-1]) +arr[a],wine(a-1));
		}
		return arr2[a];
	}
	public static void wine2(int a) {
		for (int i = 3; i <= a; i++) {
			arr2[i] = Math.max(arr2[i - 1], Math.max(arr2[i - 2] + arr[i], arr2[i - 3] + arr[i - 1] + arr[i]));
 
		}
	}
	
}
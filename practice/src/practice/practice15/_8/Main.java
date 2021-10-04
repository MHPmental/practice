package practice.practice15._8;

import java.io.*;
import java.util.*;

public class Main {

	static int[] arr;
	static int n;
	public static void main(String[] args) throws IOException {
		//1로 만들기
		//1. x가 3으로 나누어 떨어지면 3으로 나눈다.
		//2. x가 2로 나누어 떨어지면 2로 나눈다.
		//3. 아무것도 아니면 -1
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			arr[i]=-1;
		}
		arr[0] = 0;
		arr[1] = 0;
		System.out.println(one2(n,0));
	
	}
	
	//결과는 나오나 시간초과로 탈락
	public static int one(int n) {
		if(arr[n]==-1) {
			if(n%6==0) {
				arr[n] = Math.min(one(n-1), Math.min(one(n/3), one(n/2)))+1;
			}
			else if(n%3==0) {
				arr[n] = Math.min(one(n-1), one(n/3))+1;
			}
			else if(n%2==0) {
				arr[n] = Math.min(one(n-1), one(n/2))+1;
			}
			else {
				arr[n] = one(n-1)+1;
			}
		}
		return arr[n];
	}
	static int one2(int n, int count) {
		if (n < 2) {
			return count;
		}
		return Math.min(one2(n / 2, count + 1 + (n % 2)), one2(n / 3, count + 1 + (n % 3)));
	}
	
}
package practice.practice15._1;

import java.io.*;
import java.util.*;

public class Main {
	
	static Integer[][] fibo = new Integer[41][2];
	
	public static void main(String[] args) throws IOException {
		//빠르게 피보나치에서 0과 1을 호출하는 횟수 구하기
		//n의 max가 지정되어있으므로 n에서의 
		
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		
		for(int i=0;i<a;i++) {
			int n = Integer.parseInt(br.readLine());
			fibonacci(n);
			System.out.println(fibo[n][0]+" "+fibo[n][1]);
		}
		
	}	
	public static Integer[] fibonacci(int n) {
		if(fibo[n][0]==null||fibo[n][1]==null) {
			fibo[n][0]=fibonacci(n-1)[0] +fibonacci(n-2)[0];
			fibo[n][1]=fibonacci(n-1)[1] +fibonacci(n-2)[1];			
		}
		return fibo[n];
	}
}
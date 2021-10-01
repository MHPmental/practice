package practice.practice15._3;

import java.io.*;
import java.util.*;

public class Main {

	static int[] fibo = new int[10000001];
	
	public static void main(String[] args) throws IOException {
		//n개길이의 2진수를 구하는데 1로만 이루어지거나 00만들어가거나.
		//1 1
		//11 00 2
		//001 100 111 3
		//0000 0011 1001 1100 1111 5
		//00000 00001 00100 00111 10011 11001 11100 1111 8
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		fibo[0]=0;
		fibo[1]=1;
		fibo[2]=2;
		
		for(int i=3;i<fibo.length;i++) {
			fibo[i] = -1;
		}
		

		System.out.println(fibonacci(n));
	
	}	
	public static int fibonacci(int n) {
		if(fibo[n]==-1) {
			fibo[n]= (fibonacci(n-1) +fibonacci(n-2))%15746;			
		}
		return fibo[n];
	}
	
	
}
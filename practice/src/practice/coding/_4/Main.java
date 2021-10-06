package practice.coding._4;

import java.io.*;
import java.util.*;

public class Main {
	//배열
	public static int[] arr;
	//입력받을 값
	public static int n;
	public static int m;
	//결과값
	public static int count = 0;
	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//n*n의 크기의 체스판에서 m개의 룩이 존재할수있는 경우의 수
		//같은줄에는 존재할수 없다.
		//ex 5 3
		//10000 5*4*3*3+5*4*3*2+5*4*3 > 5*4*3*(3+2+1) >
		//01000
		//00100
		//00000
		//00000
		//ex 5 2
		//10000 5*4*4+5*4*3... > 5*4*(4+3+2+1) >
		//01000
		//00000
		//00000
		//00000
		//ex 3 2
		//100 3*2*2+3*2 > 18
		//010
		//000
		//이걸 생각했을때에는 n*n-1*...*n-m+1*(n-m+1+...+1)?
		//3 2일때 3-2 > 1 그러므로 2까지 3*2*(2+1) > 18
		//2 2일때에는 2-2 = 0 이므로 1까지 2*1*(1) > 2 인듯?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int result = 1;
		for(int i = n;i>=(n-m+1);i--) {
			
			result *= i;
			System.out.println(i);
			System.out.println(result);
		}
		int sum = 0;
		for(int i =(n-m+1);i>0;i--) {
			sum += i;
			System.out.println(sum);
		}
		
		System.out.println(result);
		System.out.println(sum);
		System.out.println(result*sum);
	}	
	
}
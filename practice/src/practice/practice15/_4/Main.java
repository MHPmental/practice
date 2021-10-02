package practice.practice15._4;

import java.io.*;
import java.util.*;

public class Main {
	
	static long[] arr = new long[101];
	public static void main(String[] args) throws IOException {
		//파도반 수열
		//1 1 1 2 2 3 4 5 7 9 12 16 21
		//1 1 1 2 2 까지는 직접입력 후 3(Pado(6))부터는 n-1 + n-5하면??
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(br.readLine());
			sb.append(pado(a)).append('\n');
		}
		System.out.println(sb);
	}
	public static long pado(int n) {
		if(n==0) {
			return arr[0] = 0;
		}
		if(n==1) {
			return arr[1] = 1;
		}
		if(n==2) {
			return arr[2] = 1;
		}
		if(n==3) {
			return arr[3] = 1;
		}
		if(n==4) {
			return arr[4] = 2;
		}
		if(n==5) {
			return arr[5] = 2;
		}
		if(arr[n]==-1) {
			arr[n]= (pado(n-1) +pado(n-5));			
		}
		return arr[n];
	}
}
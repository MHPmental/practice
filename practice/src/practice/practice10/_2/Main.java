package practice.practice10._2;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//피보나치 재귀로 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		System.out.println(fibo(a));
		
		
	}
	
	public static int fibo(int a) {
		if(a==0) {
			return 0;
		}else if(a==1){
			return 1;
		}else {
			return fibo(a-1)+fibo(a-2);
		}
		
	}
}
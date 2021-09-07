package practice.practice9._5;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//소수의 갯수 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a;
		while((a=Integer.parseInt(br.readLine()))!=0) {
			int count=0;
			for(int i=a+1;i<=a*2;i++) {
				if(isPrime(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
		
	}
	public static boolean isPrime(int a) {

		boolean check=true;
		if(a<2) {
			check=false;
		}else if(a==2) {
			check=true;
		}else {
			for(int j=2;j<=Math.sqrt(a);j++) {
				if(a%j==0) {
					check=false;
					break;
				}
			}
		}
		
		return check;
	}
}
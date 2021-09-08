package practice.practice9._6;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//짝수는 2개의 소수의 조합으로 만들수있다.
		//
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());

		for(int i=0;i<a;i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j=n/2;n>=0;j--) {
				if(isPrime(j)&&isPrime(n-j)) {
					System.out.println(j+" "+(n-j));
					break;
				}
				
			}
			
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
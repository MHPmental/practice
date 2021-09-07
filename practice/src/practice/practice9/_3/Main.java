package practice.practice9._3;

import java.io.*;
import java.util.*;

public class Main {
	
	public static boolean[] prime;
	public static void main(String[] args) throws IOException {
		//소수 구하기
		//N M 을 입력받아서 N~M사이의 소수를 구하는문제
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		makePrime(b);
		
		for(int i=a;i<=b;i++) {
			if(!prime[i]) {
				System.out.println(i);
			}
		}
		
		
		
		
	}
	public static void makePrime(int N) {

		prime = new boolean[N + 1];	// 0 ~ N
		
		//소수가 아닌 index = true
		//소수인 index = false
		
		if(N < 2) {
			return;
		}
        //0~1은 소수가 아니다
		prime[0] = prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			
			if(prime[i]==true) {
				continue;
			}
        
			// i 의 배수들을 걸러주기 위한 반복문
			for(int j = i*i; j < prime.length; j = j+i) {
				prime[j] = true;
			}
		}
	}
}
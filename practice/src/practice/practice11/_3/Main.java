package practice.practice11._3;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//자연수 n을 입력 받아서 분해합을 구한다.
		//분해합은 n과n을 이루는 각 자리수의 합을 의미한다.
		//생성자는 분해합으로 n을 만들수있는 수를 뜻한다.
		//가장 작은 생성자를 구해야한다.
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		
		int nl = n.length();
		
		int m =Integer.parseInt(n);
		
		int result = 0;
		//1부터 구해야 하나..?
		for(int i = (m - (nl * 9)); i < m; i++) {
			//각자리 합을 구하기위해 i를 저장할 변수
			int num = i;
			
			//각자리 합
			int sum = 0; 
			while(num != 0) {
				sum += num % 10;
				num /= 10;
			}
			if(sum + i == m) {
				result = i;
				break;
			}
			
		}
		
		System.out.println(result);
		
	}
	
}
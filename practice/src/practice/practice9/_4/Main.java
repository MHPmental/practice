package practice.practice9._4;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//소수의 갯수 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int sum = 0;
		int min = 0;
		for(int i=a; i<=b; i++) {
			boolean check=true;
			if(i==1) {
				check=false;
			}if(i==2) {
				check=true;
			}else {
				for(int j=2;j<i;j++) {
					if(i%j==0) {
						check=false;
					}
				}
			}
			if(check) {
				if(min==0) min =i;
				sum = sum+i;
			}
			
		}
		if(sum ==0) {
			System.out.println("-1");
		}else {
			System.out.println(sum);
			System.out.println(min);			
		}
	}
}
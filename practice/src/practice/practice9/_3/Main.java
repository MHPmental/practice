package practice.practice9._3;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//소수 구하기
		//N M 을 입력받아서 N~M사이의 소수를 구하는문제
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		for(int i=a;i<=b;i++) {
			if(!isNum(i)) {
				System.out.println(i);
			}
			
		}
	}
	public static boolean isNum(int a) {

		boolean check=false;
		if(a==1) {
			check=false;
		}if(a==2) {
			check=true;
		}else {
			for(int j=2;j<=Math.sqrt(a);j++) {
				if(a%j==0) {
					check=true;
					break;
				}
			}
		}
		
		return check;
	}
}
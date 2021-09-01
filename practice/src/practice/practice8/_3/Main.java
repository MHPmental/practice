package practice.practice8._3;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//분수를 순서대로 표현한다.
		// 1/1 > 1/2 > 2/1 > 3/1 > 2/2 > 1/3 > 1/4 이런식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		//1 2 3 4 5 6 홀수는 큰/작 짝수는 작/큰
		int b = 0;
		int c = 0;
		while(a>0) {
			b++;
			c = a;
			a = a-b;
		}
		if(b%2==1) {
			int d = b+1;
			System.out.println((d-c)+"/"+(c));
		}else {
			int d = b+1;
			System.out.println((c)+"/"+(d-c));
		}
	}
}

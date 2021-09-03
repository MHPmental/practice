package practice.practice8._7;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//3과 5로 딱 나눠져야한다.
		// 1  2  3  4  5  6  7  8  9 10 
		//       1 -1  1  2 -1  2  3  2
		//11 12 13 14 15 16 17 18 19 20
		// 3  4  3  4  3  4  5  4  5  4
		//21 22 23 24 25 26 27 28 29 30
		// 5  6  5  6  5  6  7  6  7  6
		//
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		
		if(a==4||a==7) {
			System.out.println("-1");
		}else if(a%5==0) {
			System.out.println(a/5);
		}else if(a%5==1||a%5==3) {
			System.out.println(a/5+1);
		}else if(a%5==2||a%5==4) {
			System.out.println(a/5+2);
		}
	}
}
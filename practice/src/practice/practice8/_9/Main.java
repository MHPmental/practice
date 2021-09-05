package practice.practice8._9;

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
		StringTokenizer st;
		for(int i=0; i<a; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = y-x;
			int j=0;
			int s=1;
			int result=0;
			while(z>0) {
				if(j==0) {
					z = z-s;
					j=1;
					result++;
				}else {
					z = z-s;
					j=0;
					s++;
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
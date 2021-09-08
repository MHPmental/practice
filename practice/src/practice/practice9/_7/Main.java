package practice.practice9._7;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//좌표 3개를 입력받아서 직사각형의 나머지 좌표를 구하는것
		//
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int aa = Integer.parseInt(st.nextToken());
		int bb = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		
		
		if(aa==a) {
			System.out.print(x);
		}else {
			if(aa==x) {
				System.out.print(a);
			}else {
				System.out.print(aa);
			}
			
		}
		
		if(bb==b) {
			System.out.println(" " + y);
		}else {
			if(bb==y) {
				System.out.println(" " + b);
			}else {
				System.out.println(" " + bb);
			}
			
		}
		
	}
	
}
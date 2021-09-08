package practice.practice9._8;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//좌표 3개를 입력받아서 직사각형의 나머지 좌표를 구하는것
		//
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		while(a!=0&&b!=0&&c!=0) {
			if(isTri(a,b,c)) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
			st = new StringTokenizer(br.readLine()," ");
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
		}
		
		
		
		
	}
	public static boolean isTri(int a,int b,int c) {
		
		if((a*a)+(b*b)==(c*c)) {
			return true;
		}
		if((a*a)+(c*c)==(b*b)) {
			return true;
		}
		if((b*b)+(c*c)==(a*a)) {
			return true;
		}
		return false;
	}
	
}
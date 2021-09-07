package practice.practice9._2;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//소수의 갯수 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int result = 0;
		for(int i=0; i<a; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(isNum(x)) {
				result++;
			}
			
		}
		System.out.println(result);
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
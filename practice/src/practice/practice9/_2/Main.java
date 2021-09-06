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
			boolean check=true;
			if(x==1) {
				check=false;
			}if(x==2) {
				check=true;
			}else {
				for(int j=2;j<x;j++) {
					if(x%j==0) {
						check=false;
					}
				}
			}
			if(check) {
				result++;
			}
			
		}
		System.out.println(result);
	}
}
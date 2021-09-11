package practice.practice10._1;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//팩토리얼 재귀로 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		System.out.println(pac(a));
		
		
	}
	
	public static int pac(int a) {
		if(a<=1) {
			return 1;
		}else {
			return a*(pac(a-1));
		}
		
	}
}
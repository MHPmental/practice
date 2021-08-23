package practice;


import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws IOException{
		//A B C 를 입력 받아서 손익 분기점을 구하는 문제 A+xB<xC 인지점이 있는지를 구하는 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int result = -1;
		//결국 A < x(C-B)가 되는 x값을 구하는문제
		// 100*x > 1099 가되는 
		//일단 c가 b보다 작거나 같으면 안된다
		//나눠지는 몫에 +1
		//아니면 1099/100=? 10+1
		if(c<=b) {
			result = -1;
		}else {
			result = (a/(c-b))+1;
		}
		System.out.println(result);
	}
}

package practice.practice8._11;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//x1,y1,r1,x2,y2,r2 가 주어진다.
		//x1,y1에서 a,b까지의 거리가 r1
		//x2,y2에서 a,b까지의 거리가 r2일때 
		//a,b가 나올수있는 위치 수를 구하는 문제 
		//두 점사이의 거리를 구하고 r1,r2의 합을 비교하여 결과갑을 출력하면 될듯
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		
		System.out.println(String.format("%.6f",a*a*Math.PI));
		
		System.out.println(String.format("%.6f",a*a*(2.0)));
		
		
	}
}
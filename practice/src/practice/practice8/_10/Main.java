package practice.practice8._10;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//유클리드 기하학과 택시 기하학에서의 원의 넓이 구하기
		//유클리드 기하학의 원 넓이 구하기 - r^2*pi
		//택시 기하학에서의 원 넓이 구하기 - r^2*2
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		
		System.out.println(String.format("%.6f",a*a*Math.PI));
		
		System.out.println(String.format("%.6f",a*a*(2.0)));
		
		
	}
}
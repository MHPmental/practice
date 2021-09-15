package practice.practice10._4;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		sb.append((int) (Math.pow(2, a) - 1)).append('\n');
		 
		Hanoi(a, 1, 2, 3);
		System.out.println(sb);
		
	}
	public static void Hanoi(int N, int start, int mid, int to) {
		// 이동할 원반의 수가 1개라면?
		if (N == 1) {
			sb.append(start + " " + to + "\n");
			return;
		}
		// STEP 1 : N-1개를 A에서 B로 이동
		Hanoi(N - 1, start, to, mid);
		
		// STEP 2 : 1개를 A에서 C로 이동
		sb.append(start + " " + to + "\n");
		
		// STEP 3 : N-1개를 B에서 C로 이동
		Hanoi(N - 1, mid, start, to);
 
	}
	
}
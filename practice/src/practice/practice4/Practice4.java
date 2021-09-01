package practice.practice4;

import java.io.*;
import java.util.*;

public class Practice4 {
	public void practice4_1() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while(x!=0&y!=0) {
			sb.append(x+y).append("\n");
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb);
	}
	public void practice4_2() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while( (line=br.readLine()) != null) {
			st = new StringTokenizer(line, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append(x+y).append("\n");
		}
		System.out.println(sb);
	}
	public void practice4_3() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int left = a/10;
		int right = a%10;
		int b = -1;
		int cnt = 0;
		while(a!=b) {
			cnt++;
			b = right*10+((left+right)%10);
			left = b/10;
			right = b%10;
		}
		System.out.println(cnt);
	}
}

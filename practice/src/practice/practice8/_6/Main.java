package practice.practice8._6;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//a층 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야한다.
		//아파트에 비어있는 집은 없고 모두 지키고 있을 경우 k층 n호에 몇명이 살고있는지 출력해라
		//아파트는 0층부터 존재하면 1호부터 있으며 0층의 i호에는 i명이 산다.
		//1 5 15 35 55
		//1 4 10 20 35
		//1 3  6 10 15
		//1 2  3  4  5
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		for(int i=0;i<cnt;i++) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			//b번째
			//a층
			int[] c = new int[b];
			//배열 초기화
			for(int j=0;j<b;j++) {
				c[j]=j+1;
			}
			for(int j=0;j<a;j++) {
				for(int k=0;k<b;k++) {
					if(k==0) {
						
					}else {
						c[k]=c[k]+c[k-1];
					}
				}
			}
			System.out.println(c[b-1]);
		}
	}
}
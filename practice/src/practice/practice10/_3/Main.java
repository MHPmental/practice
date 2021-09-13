package practice.practice10._3;

import java.io.*;
import java.util.*;

public class Main {
	static char[][] arr;
	public static void main(String[] args) throws IOException {
		//피보나치 가운데가 빈 별모양 그리기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		
		arr = new char[a][a];
		
		star(0,0,a,false);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
		
	}
	
	public static void  star(int x,int y,int a,boolean empty) {
		
		if(empty) {
			for (int i = x; i < x + a; i++) {
				for (int j = y; j < y + a; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
		if(a==1) {
			arr[x][y] ='*';
			return;
		}
		
		int size = a/3;
		int count = 0;
		for(int i = x;i<x+a;i+=size) {
			for(int j=y;j<y+a;j+=size) {
				count++;
				if(count ==5) {
					star(i,j,size,true);
				}else {
					star(i,j,size,false);
				}
			}
		}
	}
}
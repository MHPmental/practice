package practice.practice15._2;

import java.io.*;
import java.util.*;

public class Main {
	//w(a,b,c)를 저장할 배열
	static int[][][] warr = new int[21][21][21];
	
	public static void main(String[] args) throws IOException {
		//w(a,b,c) 빠르게구하기 
		
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			st=new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==-1&&b==-1&&c==-1) {
				break;
			}

			sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a,b,c)).append('\n');
			
		}
		System.out.println(sb);
		
	}	
	public static int w(int a,int b,int c) {
		if((0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20)&&warr[a][b][c]!=0) {
			return warr[a][b][c];
		}
		if(a<=0||b<=0||c<=0) {
			return 1;
		}
		if(a>20||b>20||c>20) {
			return warr[20][20][20]=w(20,20,20);
		}
		if(a<b&&b<c) {
			return warr[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
		}
		return warr[a][b][c] = w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
	}
}
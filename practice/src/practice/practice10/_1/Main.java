package practice.practice10._1;

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
		StringTokenizer st;
		for(int i=0; i<a;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			System.out.println(pointCnt(x1,y1,r1,x2,y2,r2));
			
			
		}
		
		
	}
	
	public static int pointCnt(int x1,int y1, int r1, int x2, int y2, int r2) {
		
		int disPoint = (int) (Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
		double aa = Math.pow(r1+r2, 2);
		double bb = Math.pow(r2-r1, 2);
		
		if(x1==x2&&y1==y2&&r1==r2) {
			return -1;
		}else if(disPoint >aa) {
			return 0;
		}else if(disPoint <bb) {
			return 0;
		}else if(disPoint == bb) {
			return 1;
		}else if(disPoint == aa) {
			return 1;
		}else {
			return 2;
		}
	}
}
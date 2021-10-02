package practice.practice15._5;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static int[][] color;
	public static void main(String[] args) throws IOException {
		//RGB거리
		//N개의 집이 있다. 거리는 선분으로 나타낼수있고, 1번집부터 N번집이 순서대로있다.
		//N번집은 N-1번집의 색과 같지 않아야한다.
		//i(2<=I<=N-1)번 집의 색은 i-1번,i+1번 집의 색과 같지 않아야한다.
		//빨강 초록 파랑으로 염색하는 비용이 주어진다. 그냥 작은 수를 계속 찾아가면되는데 무조건 작은거만 간다고 맞는것은 아니다.
		//그러므로 작은 누적합을 구해야한다
		//
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		color = new int[n][3];
		
		StringTokenizer st;
		
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			//빨강
			arr[i][0]=Integer.parseInt(st.nextToken());
			//초록
			arr[i][1]=Integer.parseInt(st.nextToken());
			//파랑
			arr[i][2]=Integer.parseInt(st.nextToken());
		}
		color[0][0] = arr[0][0];
		color[0][1] = arr[0][1];
		color[0][2] = arr[0][2];
		//빨강 시작, 초록 시작, 파랑시작 중에 가장 작은수를 출력
		System.out.println(Math.min(color(n-1,0),Math.min(color(n-1,1),color(n-1,2))));
		
	
	}	
	public static int color(int n,int col) {
		//비어있을 경우
		if(color[n][col]==0) {
			//빨간색
			if(col == 0) {
				color[n][0]=Math.min(color(n-1,1), color(n-1,2))+arr[n][0];
			}
			//초록색
			else if(col == 1) {
				color[n][1]=Math.min(color(n-1,0), color(n-1,2))+arr[n][1];
			}
			//파랑색
			else {
				color[n][2]=Math.min(color(n-1,0), color(n-1,1))+arr[n][2];
			}
		}
		return color[n][col];
	}
	
	
}
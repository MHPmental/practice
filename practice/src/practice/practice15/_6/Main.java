package practice.practice15._6;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] arr;
	static int[][] arr2;
	static int n;
	public static void main(String[] args) throws IOException {
		//삼각형에서 
		//맨위층부터 아래에 있는 수중 하나를 선택하여 아래층으로 갈때 선택된 수가 최대가 되는값
		//       7
		//      3 8
		//     8 1 0
		//    2 7 4 4
		//   4 5 2 6 5
		//  a b c d e f
		// g h i j k l m
		//n o p q r s t u 
		//이런식으로 가는 삼각형 배열
		//가장 아래서 부터 최대값을 구해서 맨위층으로 갔을때의 최댓값이 전체의 최댓값이다.
		
		//입력기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//전체 층수를 받는다
		n = Integer.parseInt(br.readLine());
		//n*n이 최대이므로 그만큼 받아올 배열
		arr = new int[n][n];
		//최댓값을 저장할 배열
		arr2 = new int[n][n];
		//값을 초기화해준다
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr2[i][j] =-1;
			}
		}
		//입력받은 값을 잘라주기위한 것
		StringTokenizer st;
		//값을 받아온다
		for(int i=0; i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<i+1;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//최댓값을 저장할 배열에 맨 아래층의 값을 넣어준다
		for(int i=0;i<n;i++) {
			arr2[n-1][i] = arr[n-1][i];
		}
		
		System.out.println(tri(0,0));
		
	
	}	
	public static int tri(int floor,int a) {
		//1층부터 더해준다.
		//마지막층일 경우
		if(floor == n-1) return arr2[floor][a];
		 
		// 모르는 값이면 2가지 경우의 수의 합을 비교해서 큰쪽을 가져와서 더한다.
		if (arr2[floor][a] == -1) {
			arr2[floor][a] = Math.max(tri(floor + 1, a), tri(floor + 1, a + 1)) + arr[floor][a];
		}
		//이미 존재하는 값일 경우
		return arr2[floor][a];	
	}
}
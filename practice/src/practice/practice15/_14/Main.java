package practice.practice15._14;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static char[] arr;
	static char[] arr2;
	static Integer[][] dp;
	static int[][] dp2;
	
	public static void main(String[] args) throws IOException {
		//LCS(Longest Common Subsequence)
		//두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제
		//ex) ACAYKP + CAPCAK = ACAK
		//입력은 두줄에 걸쳐서 한줄씩 문자열이 주어진다.
		//출력은 부분수열의 길이를 출력한다.
		
		//해결방안
		//n*m개의 배열을 만들어 동적계획법을 사용하면 된다.

		//입력을 담당할 버퍼리더
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//char 배열 만들어주기
		arr = br.readLine().toCharArray();
		arr2 = br.readLine().toCharArray();
		//dp 배열 초기화
		dp = new Integer[arr.length][arr2.length];
		
		System.out.println(LCS(arr.length-1,arr2.length-1));
		System.out.println(LCS2(arr.length-1,arr2.length-1));
	}
	
	public static int LCS(int a,int b) {
		//공집합일 경우 0
		if(a==-1||b==-1) {
			return 0;
		}
		//탐색하지 않았을 경우
		if(dp[a][b]==null) {
			//초기화
			dp[a][b] = 0;
			//1번 문자에서 a번째랑 2번 문자에서 b번째랑 같을경우
			if(arr[a] == arr2[b]) {
				//둘다 인덱스를 줄여주면서 dp값 증가
				dp[a][b] = LCS(a-1,b-1)+1;
			}
			//아닐경우
			else {
				dp[a][b] = Math.max(LCS(a-1,b), LCS(a,b-1));
			}
			
		}
		return dp[a][b];
	}
	public static int LCS2(int a,int b) {
		int[][] dp = new int[arr.length + 1][arr2.length + 1];
		
		// 1부터 시작 (index 0 은 공집합이므로 0의 값을 갖고있음) 
		for(int i = 1; i <= arr.length; i++) {
			for(int j = 1; j <= arr2.length; j++) {
				
				// (i-1)과 (j-1) 번째 문자가 서로 같다면  
				if(arr[i - 1] == arr2[j - 1]) {
					// 대각선 위 (i-1, j-1)의 dp에 +1 한 값으로 갱신 
					dp[i][j] = dp[i - 1][j - 1] + 1;	
				}
				
				// 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신  
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
        
		// Top-Down 때와는 다르게 dp 인덱스가 한 줄씩 추가되었으므로 -1을 하지 않음
		return dp[arr.length][arr2.length];
	}
	
}
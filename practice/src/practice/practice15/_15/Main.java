package practice.practice15._15;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] arr;
	static Integer[] dp;
	static int max;
	
	public static void main(String[] args) throws IOException {
		//n개의 정수로 이루어진 임의의 수열이 주어지고, 이 중 연속ㄷ된 몇개의 수를 선택하여 구할 수 있는 합 중 가장 큰 합을 구하려고한다.
		//수는 하나 이상 선택하여야 한다.
		//입력 첫번째줄은 입력받을 숫자의 갯수
		//두번째 줄은 입력받을 숫자 목록
		//출력은 합중에 최댓값
		
		//해결방안
		//최댓값을 저장해가면서 이중 최댓값을 구한다.

		//입력을 담당할 버퍼리더
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력받을 숫자의 수
		n = Integer.parseInt(br.readLine());
		//배열 초기화
		arr = new int[n];
		dp = new Integer[n+1];
		//쪼개줄 StringTokenizer 선언
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//배열에 값을 넣어준다
		for(int i = 0;i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//0번째의 최댓값은 arr[0]이기 때문에 값을 초기화 해준다.
		dp[0] = arr[0];
		max = arr[0];
		
		maxSum(n-1);
		System.out.println(max);
		
	}
	
	public static int maxSum(int a) {
		
		//탐색하지 않았을 경우
		if(dp[a]==null) {
			//전까지의 최댓값과 지금의 값 중에 최댓값을 저장
			dp[a] = Math.max(maxSum(a-1)+arr[a], arr[a]);
			//최댓값 갱신
			max = Math.max(max, dp[a]);
		}
		return dp[a];
	}
	public static void maxSum2(int a) {
		for (int i = 1; i < a; i++) {
			// 
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			// 최댓값 갱신 
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
	
}
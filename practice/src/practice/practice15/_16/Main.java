package practice.practice15._16;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[] arr;
	static Integer[] dp;
	static int max;
	
	public static void main(String[] args) throws IOException {
		//평범한 배낭
		//여행에 필요하다고 생각하는 n개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
		//최대 K만큼의 무게를 넣을 수 있는 배낭을 들고다닌다고 할 때에 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
		
		//입력
		//첫번째 줄에 물건의 수 N과 버틸수있는 무게K가 주어지고
		//다음줄 부터는 각각의 물건이 가지는 물건의 무게W와 가치 V가 주어진다.
		
		//출력
		//물건들의 가치합의 최댓닶을 출력한다.
		
		//해결방안
		//어렵네
		

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
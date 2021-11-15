package practice.practice15._13;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int[][] wire;
	static Integer[] dp;
	
	public static void main(String[] args) throws IOException {
		//전깃줄이 연결되어있고 이것이 교차되지않게 하는 최소한의 값을 구하시오...?
		//입력 = 첫째줄에는 전깃줄의 수가 나온다
		//이후에는 어떻게 연결되어있는지가 나온다
		
		//해결방법
		//전체 전선의 갯수에서 설치 가능한 갯수를 뺀다면 철거 갯수가 나올것이다.
		
		//입력받을 버퍼리더 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//첫째줄에서 입력받을 전선의 갯수
		n = Integer.parseInt(br.readLine());
		//입력받은 수로 부터 배열들을 초기화 해준다.
		wire = new int[n][2];
		dp = new Integer[n];
		//두번째줄 부터는 연결되는 전선을 입력 받을 것이다
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			wire[i][0] = Integer.parseInt(st.nextToken());
			wire[i][1] = Integer.parseInt(st.nextToken());
		}
		//a전봇대를 기준으로 순차정렬
		Arrays.sort(wire, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		
		int max = 0;
		
		for(int i=0;i<n;i++) {
			max = Math.max(max, pp(i));
		}
		//전체 전봇대에서 연결이 가능한 최대 전봇대를 빼면 최소한으로 빼야하는 전봇대의 갯수가 나온다.
		System.out.println(n-max);
		
	}
	
	public static int pp(int a) {
		if(dp[a]==null) {
			//일단 초기화
			dp[a] = 1;
			//지금 있는 전봇대 뒤만 확인해서 그뒤가 지금 연결하고 있는 B의 위치보다 뒤에있으면 연결이 가능하다고 본다.
			
			for(int i = a+1; i<dp.length;i++) {	
				//연결이 가능할때 
				if(wire[a][1] < wire[i][1]) {
					//현재값과 연결이 가능한 전봇대에서의 연결수+1이랑 비교를한다
					dp[a] = Math.max(dp[a], pp(i)+1);
				}
			}
			
		}
		return dp[a];
	}
	public static int pp2(int a) {
		for(int i = 0; i < dp.length; i++) {
			//일단 초기화
			dp[i] = 1;
			//i를 기준으로부터 연결이 가능한지를 봐야하
			for(int j = 0; j < i; j++) {
				if(wire[i][1] > wire[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = 0;
		for(int i = 0; i < a; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
}
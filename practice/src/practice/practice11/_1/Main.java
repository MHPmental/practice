package practice.practice11._1;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//new 블랙잭
		//카드 갯수 n m이 있는데 n장의 카드종에서 3장의 합으로 m에 가장 가까운 수를 출력
		//n은 다음 줄에 입력을 받는다
		//카드 갯수에 따른 배열을 만들어서 3장의 합을 구해 가장 가까운 경우의 수를 구한다?
		//n^3?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n-1;j++) {
				for(int k=j+1;k<n;k++) {
					int sum = arr[i]+arr[j]+arr[k];
					if(sum>m) continue;
					if(sum==m) {
						result = m;
						break;
					}
					if(sum<m&&sum>result) {
						result = sum;
					}
					
				}
				if(result==m) break;
			}
			if(result==m) break;
		}
		System.out.println(result);
		
	}	
}
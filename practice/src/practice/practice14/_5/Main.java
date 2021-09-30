package practice.practice14._5;

import java.io.*;
import java.util.*;

public class Main {
	//배열
	public static int[] arr;
	//입력받을 값
	public static int n;
	//결과값
	public static int count = 0;
	
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//n m 수열 구하기
		//중복 다 포함하기
		//뒤에는 자기보다 큰것만 나오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());


		
		arr = new int[n];
		
		queen(0);
		
		System.out.println(count);
		
		
	}	
	//백트랙킹할 함수
	public static void queen(int depth) {
		//끝까지 왔다는거는 다 채운거니까 수 ++ return
		if (depth == n) {
			count++;
			return;
		}
		
		for (int i = 0; i < n; i++) {
			arr[depth]=i;
			//이자리에 넣을수있는지 확인하고 넣을수 있으면 depth++한걸 불러온다.
			if(possible(depth)) {
				queen(depth+1);
			}
		}
	}
	
	public static boolean possible(int col) {
		for(int i=0;i<col;i++) {
			//행이 일치할 경우
			if(arr[col]==arr[i]) {
				return false;
			}
			
			//대각선
			//열의 차랑 행의 차가 같을경우 대각에 놓여있는 경우
			else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
			
		}
		
		return true;
	}
	
}
package practice.practice15._12;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	//수열
	static int[] arr;
	//앞에서 부터 실행해서 값을 넣어줄 dp
	static Integer[] front;
	//뒤에서 부터 실행해서 값을 넣어줄 dp
	static Integer[] back;
	
	public static void main(String[] args) throws IOException {
		//가장 긴 바이토닉 부분 수열
		//수열이 주어졌을대 이중에서 가장 긴 바이토닉 수열의 갯수를 출력해야함
		//입력 = 첫째줄에 수열의 갯수
		//두번째 줄에 수열이 입력 된다.
		//바이토닉 수열이란 1 2 3 1 이나 1 5 7 10 4 2와 같이 한번 쭉 증가될때와 쭉 감소 될때만이 존재 하는 수열
		
		//풀이방법
		//DP를 2개를 만들어서 증가될경우의 수와 감소될 경우의 수를 각각 구하여 합을 구하면된다.

		
		//입력받을 버퍼리더 선언
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//첫째줄에서 입력받을 수열의 갯수를 받는다.
		n = Integer.parseInt(br.readLine());
		//받은 수에 따른 배열들의 값을 초기화
		arr = new int[n];
		front = new Integer[n];
		back = new Integer[n];
		
		//두번째줄에서 수열을 받기위해 StringTokenizer를 선언하고 
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//값을 배열에 넣어준다
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//만들어둔 함수 실행
		/*for(int i =0;i<n;i++) {
			FrontDp(i);
			BackDp(i);
		}*/
		FrontDp2(n);
		BackDp2(n);
		//최댓값 초기화
		int max = -1;
		//최댓값을 구해준다
		for(int i=0;i < n;i++) {
			//System.out.println(i +"번째는"+ front[i]+" + "+back[i]+" = "+(front[i]+back[i]-1));
			max = Math.max(max, front[i]+back[i]-1);
		}
		
		System.out.println(max);
		
	}
	
	public static int FrontDp(int a) {
		//비어있을경우에만 실행
		if(front[a]==null) {
			
			front[a] = 1;
			//a보다 작은경우에만 실행을 해줘야한다
			for(int i = a-1; i>=0;i--) {
				//바이토닉이 성립되기 위해 값이 더 큰경우에만 
				if(arr[i]<arr[a]) {
					front[a] = Math.max(front[a], FrontDp(i)+1);
				}
			}
			
		}
		return front[a];
	}
	public static int BackDp(int a) {
		//비어있을 경우에 실행
		if(back[a] == null) {
			
			back[a] = 1;
			//a보다 큰 경우에만 실행
			for(int i = a+1;i<back.length;i++) {
				//바이토닉이 성립되기 위해 값이 더 큰경우에만 
				if(arr[i]<arr[a]) {
					back[a] = Math.max(back[a],BackDp(i)+1);
				}
				
			}
			
		}
		return back[a];
	}
	public static void FrontDp2(int a) {
		for(int i = 0; i < a; i++) {
			front[i] = 1;
		    
			// 0 ~ i 이전 원소들 탐색
			for(int j = 0; j < i; j++) {
		    
				// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if(arr[j] < arr[i] && front[i] < front[j] + 1) {
					front[i] = front[j] + 1;	// j번째 원소의 +1 값이 i번째 dp가 된다.
				}
			}
		}
	}
	public static void BackDp2(int a) {
		for(int i = a-1; i >= 0; i--) {
			back[i] = 1;
			//i보다큰 애들만확인
			for(int j = a-1; j > i; j--) {
		    
				// j번째 원소가 i번째 원소보다 작으면서 i번째 dp가 j번째 dp+1 값보다 작은경우
				if(arr[j] < arr[i] && back[i] < back[j] + 1) {
					back[i] = back[j] + 1;	// j번째 원소의 +1 값이 i번째 dp가 된다.
				}
			}
		}
	}
	
	
}
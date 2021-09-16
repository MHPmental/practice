package practice.practice11._2;

import java.io.*;
import java.util.*;

public class Main {
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		//몸무게와 키를 입력받아 덩치 등수를 출력한다
		//덩치등수는 자신보다 키와 몸무게 둘다 큰 사람의 수+1
		//브루트포스이기 때문에 모든걸 다해보는 경우의 수로 가면되겠다.
		//
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][2];
		
		StringTokenizer st;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()," ");	
			arr[i][0] = Integer.parseInt(st.nextToken());	//몸무게 
			arr[i][1] = Integer.parseInt(st.nextToken());	//키
		}
		
		for(int i = 0; i < n; i++) {
			//등수는 자기 위에 사람 수 +1이라서 시작이 1
			int count = 1;
			
			for(int j = 0; j < n; j++) {
				// 자기 자신이면 넘어가야한다.
				if(i == j) continue;
				// 자기보다 큰 사람이 존재한다면 등수 +1
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					count++;
				}
			}
 
			System.out.print(count + " ");
		}
		
		
	}
	
}
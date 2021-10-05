package practice.practice15._9;

import java.io.*;
import java.util.*;

public class Main {

	static Long[][] arr;
	public static void main(String[] args) throws IOException {
		//계단식으로 되어있는 수 구하기
		//4345676
		//0이면 1밖에 못오고
		//9면 8밖에 못오고
		//1~8은 +-1에서 온값의 합
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		arr = new Long[n+1][10];
		
		for(int i=0;i<10;i++) {
			arr[1][i] = 1L;
		}
		
		long result =0;
		
		stairs2(n);
		
		for(int i=1;i<10;i++) {
			//result += stairs(n,i);
			result += arr[n][i];
		}
		
		
		
		System.out.println(result%1000000000);
	
	}
	
	public static long stairs(int a,int b) {
		if(a==1) {
			return arr[a][b];
		}
		if(arr[a][b]==null) {
			if(b==0) {
				arr[a][b] = stairs(a-1,1);
			}
			else if(b==9) {
				arr[a][b] = stairs(a-1,8);
			}else {
				arr[a][b] = stairs(a-1,b-1)+stairs(a-1,b+1);
			}
		}
		return arr[a][b]%1000000000;
	}
	public static void stairs2(int a) {
		for(int i = 2; i <= a; i++) {
			//몇번째 자리수 인지 i를 통해 판단하고
			for(int j = 0; j < 10; j++) {
				//현재 보는 값이 0이라면 전 자리의 1만 올수있다 
				if(j == 0) {
					arr[i][0] = arr[i - 1][1] % 1000000000;
				}
				//현재 보는 값이 9라면 전 자리의 8만 올수있다
				else if (j == 9) {
					arr[i][9] = arr[i - 1][8] % 1000000000;
				}
				//그 외의 값은 이전 자라의 +1,-1 의 합
				else {
					arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
				}
			}
		}
	}
	
}
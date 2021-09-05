package practice.practice8._9;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//입렵받은 두수 x~y사이에서 걸리는 시간을 구하는 문제
		//한번에 갈수있는 거리는 1부터 시작하고 끝은 무조건 1이여야한다.
		//다음에 갈수있는거리는 지금 간 거리로 부터 -1 +1 +0 인 거리만 갈수있다.
		//ex) 0~3 은 111로 3번 0~4는 121 0~5는 1121 ... 이런식
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0; i<a; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = y-x;
			int j=0;
			int s=1;
			int result=0;
			while(z>0) {
				if(j==0) {
					z = z-s;
					j=1;
					result++;
				}else {
					z = z-s;
					j=0;
					s++;
					result++;
				}
			}
			System.out.println(result);
		}
	}
}
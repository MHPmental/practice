package practice.practice8._5;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//층 호수 몇번째 손님을 입력받아서 손님이 들어가있는 호수를 구하는 문제
		//엘베에서 가까울수록 층계는 낮을수록 빨리찬다
		//호수는 aabb이런식으로 나와야한다.
		//a b c라고 입력을 받았을때에 c%a를 구해서 이것이 0이면
		//c%a가 0이 아니라면 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<cnt;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = (c/a);
			int e = c%a;
			if(e==0) {
				System.out.println(a*100+d);
				
			}else {
				System.out.println(e*100+(d+1));
				
			}
		}
	}
}
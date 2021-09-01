package practice.practice8;

import java.io.*;
import java.util.StringTokenizer;

public class Practice8 {
	public void practice8_1() throws IOException{
		//A B C 를 입력 받아서 손익 분기점을 구하는 문제 A+xB<xC 인지점이 있는지를 구하는 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int result = -1;
		//결국 A < x(C-B)가 되는 x값을 구하는문제
		// 100*x > 1099 가되는 
		//일단 c가 b보다 작거나 같으면 안된다
		//나눠지는 몫에 +1
		//아니면 1099/100=? 10+1
		if(c<=b) {
			result = -1;
		}else {
			result = (a/(c-b))+1;
		}
		System.out.println(result);
	}
	public void practice8_2() throws IOException{
		//육각형의 벌집에서 칸이동수 구하기
		//1 + 6 + 6*2 + 6*3 + .... +6*n
		//1일때는 1
		//2~7 2 
		//수를 입력받고 수가 0이될때까지 while을 돌리고 그때까지의 수를 구한다?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int result=0;
		int b=0;
		while(a>0) {
			if(a==1&&b==0) {
				a--;
			}
			else {
				if(b==0) {
					b++;
					a--;
				}else {
					a = a-(6*b);
					b++;
				}
			}
			result++;
		}
		System.out.println(result);
	}
}

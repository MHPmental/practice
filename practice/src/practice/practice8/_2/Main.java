package practice.practice8._2;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
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

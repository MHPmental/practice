package practice.practice8._4;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//달팽이가 올라가고 내려가고
		//c를 올라갈때 a를 올라가고 b를 떨어진다고 했을때 걸리는 날짜
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = 0;
		d = (c-a)/(a-b);
		int e = (c-a)%(a-b);
		if(c==a) {
			System.out.println(1);
		}
		else if(e==0) {
			System.out.println(d+1);
		}else {
			System.out.println(d+2);
		}
		
		
	}
}
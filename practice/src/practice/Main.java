package practice;


import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = reverseNum(st.nextToken());
		int b = reverseNum(st.nextToken());
		if(a>b) {
			System.out.println(a);
		}else {
			System.out.println(b);
		}
	}
	public static int reverseNum(String a) {
		int result=0;
		StringBuffer sb = new StringBuffer();
		for(int i=a.length()-1;i>=0;i--) {
			sb.append(a.charAt(i));
		}
		result = Integer.parseInt(sb.toString());
		return result;
	}
}

package practice.practice8._8;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		//큰수 합구하기
		//long보다 크다?
		//1자리부터 String 2개를 가져와서 더하면 되지않을까
		//1000개의 자리수는 정해져있다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		String a = st.nextToken();
		String b = st.nextToken();
		//0의 자리수 부터 배열에 저장하고 적은자리부터 더해서 10보다 크면 다음자리수 +1하면될거같다.
		char[] aa = new char[a.length()];
		char[] bb = new char[b.length()];
		//20 20-0-1 19
		//20 20-19-1 0
		for(int i=0;i<a.length();i++) {			
			aa[i] = a.charAt(a.length()-i-1);
		}
		for(int i=0;i<b.length();i++) {
			bb[i] = b.charAt(b.length()-i-1);
		}
		StringBuilder sb = new StringBuilder();
		if(a.length()==b.length()) {
			int x = 0;
			for(int i=0;i<b.length();i++) {
				if(i<a.length()-1) {
					int xx = Character.getNumericValue(aa[i])+Character.getNumericValue(bb[i])+x;
					if(xx>=10) {
						x = 1;
					}else {
						x = 0;
					}
					sb.append(xx%10);
				}else {
					int xx = Character.getNumericValue(aa[i])+Character.getNumericValue(bb[i])+x;
					if(xx>=10) {
						sb.append(xx%10);
						sb.append("1");
					}else {
						sb.append(xx%10);
					}
					
				}
			}
		}else if(a.length()<b.length()) {
			int x = 0;
			for(int i=0;i<b.length();i++) {
				if(i<a.length()) {
					int xx = Character.getNumericValue(aa[i])+Character.getNumericValue(bb[i])+x;
					if(xx>=10) {
						x = 1;
					}else {
						x = 0;
					}
					sb.append(xx%10);
				}else {
					int xx = Character.getNumericValue(bb[i])+x;
					if(i==b.length()-1) {
						x=0;
						sb.append(xx%10);
						if(xx>=10)
						sb.append("1");
					}else {
						if(xx>=10) {
							x=1;
						}else {
							x=0;
						}
						sb.append(xx%10);
					}
				}
			}
		}else {
			int x = 0;
			for(int i=0;i<a.length();i++) {
				if(i<b.length()) {
					int xx = Character.getNumericValue(aa[i])+Character.getNumericValue(bb[i])+x;
					if(xx>=10) {
						x = 1;
					}else {
						x = 0;
					}
					sb.append(xx%10);
				}else {
					int xx = (Character.getNumericValue(aa[i]))+x;
					if(i==a.length()-1) {
						x=0;
						sb.append(xx%10);
						if(xx>=10)
						sb.append("1");
					}else {
						if(xx>=10) {
							x=1;
						}else {
							x=0;
						}
						sb.append(xx%10);
					}
				}
			}
		}
		
		for(int i=sb.length()-1;i>=0;i--) {
			System.out.print(sb.charAt(i));
		}
	}
}
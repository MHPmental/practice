package practice;


import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws IOException{
		//그룹단어 체크
		//aavvdd 는 avd가 연속으로 나오므로 그룹단어 aavvdda는 avda이므로 a가 2번 나와서 그룹단어가 아니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//들어올 문자 수
		int trycnt = Integer.parseInt(br.readLine());
		int result=0;
		for(int i=0; i<trycnt;i++) {
			String str = br.readLine();
			StringBuffer sb = new StringBuffer();
			//1. 일단 문자열 연속되는걸 없애는걸 목표로 해서  aavvdda > avda
			for(int j=0; j<str.length();j++) {
				if(j==0) {
					sb.append(str.charAt(j));
				}
				else if(j>0&&str.charAt(j)==str.charAt(j-1)){
					
				}
				else {
					sb.append(str.charAt(j));
				}
			}
			//2. avda에서 2번 연속으로 나오는 친구가 있으면 문제있는친구
			int a=0;
			for(int j=0;j<sb.length()-1;j++) {
				for(int k=j+1;k<sb.length();k++) {
					if(sb.charAt(j)==sb.charAt(k)) {
						a=-1;
					}
				}
			}
			if(a==0) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}

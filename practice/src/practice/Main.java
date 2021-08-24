package practice;


import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws IOException{
		//문자열을 입력받아서 크로아티아 문자갯수 구하기
		//앞에서부터 천천히 나가면서 경우의수를 하면서 숫자 늘리기해야지
		//끝에 올경우를 생각해야됨..
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int cnt = 0;
		for(int i=0;i<str.length();i++) {
			if(i<str.length()-1&&str.charAt(i)=='c'&&str.charAt(i+1)=='=') {
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='c'&&str.charAt(i+1)=='-') {
				i++;
			}else if(i<str.length()-2&&str.charAt(i)=='d'&&str.charAt(i+1)=='z'&&str.charAt(i+2)=='=') {
				i++;
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='d'&&str.charAt(i+1)=='-') {
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='l'&&str.charAt(i+1)=='j') {
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='n'&&str.charAt(i+1)=='j') {
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='s'&&str.charAt(i+1)=='=') {
				i++;
			}else if(i<str.length()-1&&str.charAt(i)=='z'&&str.charAt(i+1)=='=') {
				i++;
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}

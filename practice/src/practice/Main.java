package practice;


import java.io.*;
import java.util.*;


class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt=0;
		String a = br.readLine();
		for(int i=1;i<=Integer.parseInt(a);i++) {
			if(i<10) {
				cnt++;
			}else if(i<100) {
				cnt++;
			}else {
				int x = i/100;
				int y = (i-x*100)/10;
				int z = (i-x*100-y*10);
				if((y-x)==(z-y)) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}

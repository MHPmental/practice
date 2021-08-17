package practice;

import java.io.*;

public class Practice6 {
	public void practice6_1() throws IOException{
		
	}
	public long sum(int[] a) {
		long sumNum = 0;
		for(int i =0;i<a.length;i++) {
			sumNum += a[i];
		}
		return sumNum;
	}
	public void practice6_2() throws IOException{
		
		int[] result = new int[10000];
		for(int i=0; i<result.length;i++) {
			result[i]=0;
		}
		for(int i=0;i<result.length;i++) {
			if(i<10) {
				result[i*2]=-1;
			}else if(i<100) {
				int a = i/10;
				int b = i-a*10;
				result[i+a+b] = -1;
			}else if(i<1000) {
				int a = i/100;
				int b = (i-a*100)/10;
				int c = (i-a*100-b*10);
				result[i+a+b+c] = -1;
			}else {
				int a = i/1000;
				int b = (i-a*1000)/100;
				int c = (i-a*1000-b*100)/10;
				int d = (i-a*1000-b*100)-c*10;
				if(i+a+b+c+d>=10000) {
					
				}else {
					result[i+a+b+c+d] = -1;
				}
				
			}
		}
		
		for(int i=0; i<result.length;i++) {
			if(result[i]==0) {
				System.out.println(i);
			}
		}
		
	}
	public void practice6_3() throws IOException{
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
